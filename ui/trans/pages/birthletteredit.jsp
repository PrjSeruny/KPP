<%@page import="com.sync.master.utils.MasterConstants"%>
<%@page import="com.sync.trans.beans.BirthLetterBean"%>
<%@page import="com.sync.trans.beans.DeathLetterBean"%>
<%@page import="com.sync.trans.utils.TransConstants"%>
<%@page import=" java.io.*,
               com.sync.core.utils.Constants,
               com.sync.core.beans.MessageBean,
               com.sync.core.utils.Utilities,
               com.sync.master.beans.MasterUserBean"
%>
<%
   String act = (String)request.getAttribute(TransConstants.ACT);
   BirthLetterBean ubn = (BirthLetterBean)request.getAttribute(TransConstants.BIRTHLETTER_INFO);
   MessageBean msg = null;
   String type="";
   System.out.println(">>>>>>>>>>>>> JSP ACTION= "+act);
   String genmsg ="";
   if(null!=ubn)
   {
     msg = ubn.getBeanMessages();
     if(null!=msg)
     {
       genmsg = msg.getMessageBean(MessageBean.MSG_ERR);
       System.out.println(">>>>>>>>>>>>> genmsg= "+genmsg);
     }
   }
   
%>
<fieldset class="wrapper">
<%
   if(!Utilities.isEmpy(genmsg))
   {
%>
      <font color="red"><%=!Utilities.isEmpy(genmsg)?genmsg:""%></font>
<% 
   }
%>
  <form name="create" method="post" action="<%=Constants.ROOT_PATH%><%=TransConstants.SVT_TRANS_PATH%>">
     <input type="hidden" name="<%=TransConstants.W%>" value="<%=TransConstants.TRANS_BIRTHLETTER%>">
     <input type="hidden" name="<%=TransConstants.ACT%>" value="<%=act%>">
    <div class="form">
      <h2 class="title">Surat Kelahiran</h2>
      <label class="errormsg"><%=null!=msg?msg.showMessage(TransConstants.ERRORMSG_PAGE):""%></label>
      <fieldset>
        <div>
          <label><font color="red">#</font>NIK</label>
<%
   if(!Utilities.isEmpy(act) && act.equals(TransConstants.ACT_UPDATE_SAVE)) type = "hidden";
   else type="text";
%>            
               <input type="<%=type%>" name="<%=TransConstants.FORM_TRANS_BIRTHLETTER_NIK%>" value="<%=null!=ubn?Utilities.showStringValue(ubn.getNIK()):""%>">
<%
   if(!Utilities.isEmpy(act) && act.equals(TransConstants.ACT_UPDATE_SAVE))
   {
     out.println(ubn.getNIK());
   }
%>               
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(TransConstants.FORM_TRANS_BIRTHLETTER_NIK):""%></span>
        </div>
        <div>
          <label><font color="red">#</font>No.KK</label>
          <input type="text" name="<%=TransConstants.FORM_TRANS_BIRTHLETTER_KKNO%>" value="<%=null!=ubn?Utilities.showStringValue(ubn.getKKNo()):""%>">
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(TransConstants.FORM_TRANS_BIRTHLETTER_KKNO):""%></span>
        </div>
      </fieldset>
      <fieldset>
        <div>
          <label><font color="red">#</font>Nama</label>
          <input type="text" name="<%=TransConstants.FORM_TRANS_BIRTHLETTER_NAME %>" value="<%=null!=ubn?Utilities.showStringValue(ubn.getName()):""%>">
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(TransConstants.FORM_TRANS_BIRTHLETTER_NAME):""%></span>
        </div>
        <div >
          <label><font color="red">#</font>Tanggal Kelahiran</label>
          <input type="text" class="date" name="<%=TransConstants.FORM_TRANS_BIRTHLETTER_BIRTHDATE%>" value="<%=null!=ubn?Utilities.showStringValue(Utilities.dateToString(ubn.getBirthDate(), TransConstants.DATE_HTML_SHORT_PATTERN)):""%>">
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(TransConstants.FORM_TRANS_BIRTHLETTER_BIRTHDATE):""%></span>
        </div>
      </fieldset>
      <fieldset>
        <div>
          <label><font color="red">#</font>NIK Ayah</label>
          <input type="text" id="userIDVal"  readonly="readonly" name="<%=TransConstants.FORM_TRANS_BIRTHLETTER_FATHERNIK%>" value="<%=null!=ubn?Utilities.showStringValue(ubn.getFatherNIK()):""%>">
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(TransConstants.FORM_TRANS_BIRTHLETTER_FATHERNIK):""%></span>
        </div>
        <div>
          <label><font color="red">#</font>Nama Ayah</label>
          <a href="javascript:void(0)" 
    class="lookup"
    valTarget="#userIDVal;#userNameVal"
    param="width=450;height=300"
    url="<%=Constants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>?<%=Constants.W%>=<%=MasterConstants.MASTER_RESIDENT%>&<%=MasterConstants.ACT%>=<%=MasterConstants.ACT_LOOKUP%>&<%=MasterConstants.LOOKUP_SINGLE%>=1">Cari</a>
          <input type="text" id="userNameVal" readonly="readonly" name="<%=TransConstants.FORM_TRANS_BIRTHLETTER_FATHERNAME%>" value="<%=null!=ubn?Utilities.showStringValue(ubn.getFatherName()):""%>">
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(TransConstants.FORM_TRANS_BIRTHLETTER_FATHERNAME):""%></span>
        </div>
       </fieldset>
       <fieldset>
        <div>
          <label><font color="red">#</font>NIK Ibu</label>
          <input type="text" id="userIDVal2" readonly="readonly" name="<%=TransConstants.FORM_TRANS_BIRTHLETTER_MOTHERNIK%>" value="<%=null!=ubn?Utilities.showStringValue(ubn.getMotherNIK()):""%>">
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(TransConstants.FORM_TRANS_BIRTHLETTER_MOTHERNIK):""%></span>
        </div>
        <div>
          <label><font color="red">#</font>Nama Ibu</label>
          <a href="javascript:void(0)" 
    class="lookup"
    valTarget="#userIDVal2;#userNameVal2"
    param="width=450;height=300"
    url="<%=Constants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>?<%=Constants.W%>=<%=MasterConstants.MASTER_RESIDENT%>&<%=MasterConstants.ACT%>=<%=MasterConstants.ACT_LOOKUP%>&<%=MasterConstants.LOOKUP_SINGLE%>=1">Cari</a>
          <input type="text" id="userNameVal2"  readonly="readonly" name="<%=TransConstants.FORM_TRANS_BIRTHLETTER_MOTHERNAME%>" value="<%=null!=ubn?Utilities.showStringValue(ubn.getMotherName()):""%>">
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(TransConstants.FORM_TRANS_BIRTHLETTER_MOTHERNAME):""%></span>
        </div>
       </fieldset>
      <fieldset>
        <div class="full">
          <label>Note</label>
          <textarea rows="5" cols="50" name="<%=TransConstants.FORM_TRANS_BIRTHLETTER_NOTE%>"><%=null!=ubn?Utilities.showStringValue(ubn.getNote()):""%></textarea>
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(TransConstants.FORM_TRANS_BIRTHLETTER_NOTE):""%></span>
        </div>
      </fieldset>
      <fieldset>
        <div>
          <input type="submit" value="Simpan">
      <%
      if(!Utilities.isEmpy(act) && act.equals(TransConstants.ACT_CREATE))
      {
      %>     
           <input type="reset" value="Reset" class="negate">
      <%
      }
      else
      {
      %>
           <input type="submit" name="<%=TransConstants.BTN_CANCEL%>" value="Batal" class="negate">
      <%  
      }
      %>
        </div>
      </fieldset>
    </div>
  </form>
</fieldset>