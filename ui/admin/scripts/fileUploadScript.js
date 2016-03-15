var options;
$.fn.serializeObject = function()
{
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};

$(function(){
  $("#UploadForm input[type=file]").change(function(){
    if($(this).val()!=""){
      //alert($(this).val());
      $("#UploadForm").ajaxForm(options);
      $("#UploadForm").submit();
    }
  });

  $(document).on("click",".form .upload-img a.new,.form .upload-img a.update",function(){
    var upload = $("#UploadForm").find("input[type=file]");
    var btn = $(this);
    var destImg = $(this).closest("li");
    var destInput = destImg.find(".inputPath");
    var destInput_thumb = destImg.find(".inputPath_thumb");

    if(destImg.is("[url]")){$("#UploadForm").attr("action",destImg.attr("url"))}

    upload.click();

    options = {
      dataType: 'json',
      data: destImg.find('form, .addParam :input').serializeObject(),
      beforeSend : function() {
        $("#progressbox").show();
        $("#UploadForm").click(function(){void(0);});
        // clear everything
        $("#progressbar").width('0%');
        $("#message").empty();
        $("#percent").html("0%");
        $("#message").html("<font color='blue'>Sedang mengunggah file ... </font>");

        $("#UploadForm").show();
      },
      uploadProgress : function(event, position, total, percentComplete) {
        $("#progressbar").width(percentComplete + '%');
        $("#percent").html(percentComplete + '%');
      },
      success : function(data) {
        document.getElementById("UploadForm").reset();
        if(data.ajax_status=="error"){
          $("#progressbar").width('0%');
          $("#percent").html('0%');
          $("#message").html("<font color='#FF0016'>"+data.msg+"</font>");
          $("#UploadForm").click(function(){$(this).fadeOut("fast");});
        }else{
          $("#progressbar").width('100%');
          $("#percent").html('100%');
          $("#message").html("<font color='#5AFF70'>File berhasil di unggah!</font>");
          //alert(destImg);
          destImg.css({"background-image":"url('."+data.path_thumb+"?"+new Date().getTime()+"')"});
          destInput.val(data.path);
          destInput_thumb.val(data.path_thumb);

          if(btn.hasClass("new")){
            btn.removeClass("new");
            btn.addClass("update");
            btn.attr("title","Ubah");
            destImg.prepend("<a href='javascript:void(0)' class='imgdel' title='Hapus'></a>");
            destImg.prepend("<a href='javascript:void(0)' class='imgview' imgpath='."+data.path+"' title='Lihat'></a>");
          }else{
            destImg.find(".imgview").attr("imgpath","."+data.path);
          }
          $("#UploadForm").delay(1000).fadeOut("fast");
        }

      },
      error : function() {
        document.getElementById("UploadForm").reset();
        $("#progressbar").width('0%');
        $("#percent").html('0%');
        $("#message").html("<font color='red'> ERROR: gagal mengunggah file!</font>");
        $("#UploadForm").click(function(){$(this).fadeOut("fast");});
      }
    };

  });

  $(document).on("mouseenter",".form .upload-img li",function(){
    $(this).find(".imgdel,.update,.imgview").css("display","inline-block");
  });
  $(document).on("mouseleave",".form .upload-img li",function(){
    $(this).find(".imgdel,.update,.imgview").hide();
  });

  $(document).on("click",".imgview",function(){
    var urlImg = $(this).attr("imgpath");

    $("#imagePreview img").attr("src",urlImg+"?"+new Date().getTime());
    $("#imagePreview").fadeIn("fast");
  });

  $(document).on("click","#imagePreview a",function(){
    $("#imagePreview img").attr("src","");
    $("#imagePreview").fadeOut("fast");
  });

  $(document).on("click",".form .upload-img a.imgdel",function(){
    var destInput = $(this).closest("li").find(".inputPath");
    var destInput_thumb = $(this).closest("li").find(".inputPath_thumb");
    var btn = $(this);
    var destImg = $(this).closest("li");
    var btnUpdate = $(this).closest("li").find("a.update");
    var btnView = $(this).closest("li").find("a.imgview");

    var frmURL = $("#UploadForm").attr("action");

    if(destImg.is("[url]")){frmURL = destImg.attr("url");}

    var addData = destImg.find('form, .addParam :input').serializeObject();
    addData['act'] = 'actdlt';

    $.ajax({
      type: 'post', // it's easier to read GET request parameters
      url: frmURL,
      dataType: 'JSON',
      data: addData,
      success: function(data) {
        if(data.ajax_status=="error"){
          alert(data.msg);
        }else{
          btnUpdate.removeClass("update");
          btnUpdate.addClass("new");
          btnUpdate.attr("title","Unggah Gambar");
          btnUpdate.removeAttr("style");
          destImg.css("background-image","none");
          destInput.val("");
          destInput_thumb.val("");
          btnView.remove();
          btn.remove();
          parent.cover(false);
        }
      },
      error: function() {
        alert('ERROR : Tidak dapat menghapus file!');
        parent.cover(false);
      }
    });
  });
});