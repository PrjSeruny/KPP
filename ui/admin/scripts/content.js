  	var lookupTarget = [];
	var lookupValues=[];

  //FUNCTION FOR POSTING AJAX FORM WITH DATA TYPE HTML/TEXT
  function postAjaxHtml(form,url,id){
    $.post( url, form.serialize())
      .done(function(data) {
        $(id).html(data);
        initFormAjaxHtml();
      })
      .fail(function() {
        alert( "error" );
      })
      .always(function() {
        parent.cover(false);
    });
  }

  $.ajaxSetup({
    beforeSend: function(){
      parent.cover(true);
    }
  });
  //FUNCTION FOR INITIAL AJAX SUBMIT
  function initFormAjaxHtml(){
    $(".ajax-form").unbind("submit");
    $(".ajax-form").bind("submit", function(event){    

	  $(document).off();
      var frmURL = $(this).attr("action");
      var dst = "#"+$(this).attr("dst");
      postAjaxHtml($(this),frmURL,dst);
      event.preventDefault();

    });
  }

  //FUNCTION FOR OPEN POPUP WINDOW
	function PopupCenter(url, title, prm) {
	    var w = prm["width"];
	    var h = prm["height"];

	    var param = "";
	    jQuery.each(prm, function(i, val){
	      param += i+"="+ val+",";
	    });

	    // Fixes dual-screen position                         Most browsers      Firefox
	    var dualScreenLeft = window.screenLeft != undefined ? window.screenLeft : screen.left;
	    var dualScreenTop = window.screenTop != undefined ? window.screenTop : screen.top;

	    var width = window.innerWidth ? window.innerWidth : document.documentElement.clientWidth ? document.documentElement.clientWidth : screen.width;
	    var height = window.innerHeight ? window.innerHeight : document.documentElement.clientHeight ? document.documentElement.clientHeight : screen.height;

	    var left = ((width / 2) - (w / 2)) + dualScreenLeft;
	    var top = ((height / 2) - (h / 2)) + dualScreenTop;
	    var newWindow = window.open(url, title, 'scrollbars=yes, ' + param + ' top=' + top + ', left=' + left);

	    // Puts focus on the newWindow
	    if (window.focus) {
	        newWindow.focus();
	    }
	}

	function pushArr(arrVar,val){
		if(arrVar.indexOf(val) < 0){
  			arrVar.push(val);
  			return arrVar;
	  	}
	  	return arrVar;
	}

	function pullArr(arrVar,val){
		if(arrVar.indexOf(val) > -1){
	  		arrVar.splice(arrVar.indexOf(val),1);
  			return arrVar;
	  	}
	  	return arrVar;
	}

  //TRIGGER ACTIVE WHEN DOM IS LOADED
  $(window).load(function(){
    initFormAjaxHtml();
  });

  	
  
$(function(){

	  /*########## FUNCTION FOR PAGINATION #############*/
	  $(document).on("click",".pagination a",function(){
		  var nav = $(this).closest("li").attr("class");
		  var ipage = $(this).closest("ul").find(".page select");
		  var pgnform = $(this).closest("form");
		  var vl = 1;
		
		  if(nav=="next"){
		    vl = parseInt(ipage.val())+1;
		  }else if(nav=="prev"){
		    vl = parseInt(ipage.val())-1;
		  }else if(nav=="first"){
		    vl = 1;
		  }else if(nav=="last"){
		    vl = parseInt(ipage.attr("max"));
		  }
			
		  ipage.val(vl);
		  pgnform.submit();
	  });    

	$(document).on("click",".pagination .page span",function(){
	  var ipage = $(this).closest("li").find("select");
	  $(this).hide();
	  ipage.show();
	  ipage.focus();
	});    
	
	$(document).on("blur",".pagination .page select",function(){
	  var vpage = $(this).closest("li").find("span");
	  $(this).hide();
	  vpage.show();
	});
	
	$(document).on("change",".pagination .page select",function(){
	  var pgnform = $(this).closest("form");
	  var vl = $(this).val();
	  pgnform.submit();
	});
	
	$(document).on("change",".drecord select",function(){
	  var pgnform = $(this).closest("form");
	  var ipage = $(".pagination .page select");
	  ipage.val("1");
	  pgnform.submit();
	});
	/*########## END #############*/

	/*########## FUNCTION FOR SEARCH LIST #############*/
	$(document).on("click",".form .search a",function(){
	  var pgnform = $(this).closest("form");
	  var ipage = $(this).closest("form").find(".page select");
	  if(ipage.length > 0){
	    ipage.val(1);
	  }
	  pgnform.submit();
	}); 

	$(document).on("click",".form a.reload",function(){
	  var pgnform = $(this).closest("form");
	  var srch = $(this).closest("form").find(".search input");
	  var ipage = $(this).closest("form").find(".page select");
	  
      ipage.val(1);
      srch.val("");

	  pgnform.submit();
	}); 

	$(document).on("click",".form a.delete",function(){
	  var pgnform = $(this).closest("form");
	  var delitems = $(".del:checkbox:checked");
	  var act = $(".form [name='act']");
	  var ipage = $(".pagination .page select");

	  if(delitems.length > 0){
	  	if(confirm("Anda yakin akan menghapus item yang dipilih?")){
		  act.val("actdlt");

		  pgnform.submit();
	  	}
	  }else{
	  	alert("Silahkan centang item yang akan dihapus!");
	  }
	}); 

	$(document).on("click",".selAll",function(){
	  var childs = $("."+$(this).attr("child"));
	  childs.prop("checked", $(this).prop("checked"));

	  if($(this).hasClass("putValues")){
	  	var lookupTarget = self.opener.lookupTarget;
	  	if($(this).prop("checked")){
	  		childs.each(function(){
	  			pushArr(lookupValues,this.value);
	  		});
	  	}else{
			childs.each(function(){
	  			pullArr(lookupValues,this.value);
	  		});
	  	}
	  	for(var i=0;i<lookupTarget.length;i++)
		{
			self.opener.$(lookupTarget[i]).val(lookupValues.join(";"));
		}
	  }

	}); 

	$(document).on("click",".selChild",function(){
	  var parent = $("."+$(this).attr("parent"));
	  var childs = $("."+parent.attr("child"));
	  var checkedlist = $("."+parent.attr("child")+":checkbox:checked");

	  if ($(this).prop("checked")) {
	  	if(childs.length == checkedlist.length){
	  		parent.prop("checked",true);
	  	}
	  }else{
	  		parent.prop("checked",false);
	  }

	  if($(this).hasClass("putValues")){
	  	var lookupTarget = self.opener.lookupTarget;
		if($(this).prop("checked")){
			lookupValues = pushArr(lookupValues,$(this).val());
		}else{
			lookupValues = pullArr(lookupValues,$(this).val());
		}
		for(var i=0;i<lookupTarget.length;i++)
		{
			self.opener.$(lookupTarget[i]).val(lookupValues.join(";"));
		}
	  }
	}); 

	$(document).on("keydown",".form .search input",function(event){
	  if(event.keyCode == 13) {
	    var pgnform = $(this).closest("form");
	    var ipage = $(this).closest("form").find(".page select");
        if(ipage.length > 0){
          ipage.val(1);
        }
        pgnform.submit();
        event.preventDefault();
        return false;
      }
    });
	/*########## END #############*/


	$(document).on("click",".lookup",function(){
		lookupTarget = $(this).attr("valTarget").split(";");
		var url = $(this).attr("url");
		var title = "Lookup";
		var lookupPrm = [];
		var param = {};
		param['width'] = '400';param['height'] = '300';param['scrollbars'] = 'yes';param['resizable'] = 'yes';

		if($(this).is("[param]") && $(this).attr("param")!=""){
		  lookupPrm = $(this).attr("param").split(";");
		  var temp = [];
		  for(var i=0;i<lookupPrm.length;i++){
		    temp = lookupPrm[i].split("=");
		    param[temp[0]] = temp[1];
		  }
		}

		if($(this).is("[title]") && $(this).attr("title")!=""){
		  title = $(this).attr("title");
		}

		PopupCenter(url,title,param);
	});

	
	$(".putValue").click(function(){
		var lookupTarget = self.opener.lookupTarget;
		var value = [];
		value = $(this).attr("value").split(";");

		for(var i=0;i<lookupTarget.length;i++)
		{
			var el = self.opener.$(lookupTarget[i]);

			if(el.is("input, textarea, select")){
				el.val(value[i]);
			}else{
				el.html(value[i]);
			}
		}
		
		window.close();
	});

});