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
   DeathLetterBean ubn = (DeathLetterBean)request.getAttribute(TransConstants.DEATHLETTER_INFO);
   MessageBean msg = null;
   String type="";
   System.out.println(">>>>>>>>>>>>> JSP ACTION= "+act);
   
   if(null!=ubn)
   {
     msg = ubn.getBeanMessage();
   }
   
%>
<fieldset class="wrapper">
  <form name="create" method="post" action="<%=Constants.ROOT_PATH%><%=TransConstants.SVT_TRANS_PATH%>">
     <input type="hidden" name="<%=TransConstants.W%>" value="<%=TransConstants.TRANS_DEATHLETTER%>">
     <input type="hidden" name="<%=TransConstants.ACT%>" value="<%=act%>">
    <div class="form">
      <h2 class="title">Surat Kematian</h2>
      <label class="errormsg"><%=null!=msg?msg.showMessage(TransConstants.ERRORMSG_PAGE):""%></label>
      <fieldset>
        <div >
          <label>NIK</label>
<%
   if(!Utilities.isEmpy(act) && act.equals(TransConstants.ACT_UPDATE_SAVE)) type = "hidden";
   else type="text";
%>            
               <input type="<%=type%>" name="<%=TransConstants.FORM_TRANS_DEATHLETTER_NIK%>" value="<%=null!=ubn?Utilities.showStringValue(ubn.getNIK()):""%>">
<%
   if(!Utilities.isEmpy(act) && act.equals(TransConstants.ACT_UPDATE_SAVE))
   {
     out.println(ubn.getNIK());
   }
%>               
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(TransConstants.FORM_TRANS_DEATHLETTER_NIK):""%></span>
        </div>
      </fieldset>
      <fieldset>
        <div>
          <label>Nama</label>
          <input type="text" name="<%=TransConstants.FORM_TRANS_DEATHLETTER_NAME %>" value="<%=null!=ubn?Utilities.showStringValue(ubn.getName()):""%>">
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(TransConstants.FORM_TRANS_DEATHLETTER_NAME):""%></span>
        </div>
        <div >
          <label>Tanggal Kematian</label>
          <input type="text" name="<%=TransConstants.FORM_TRANS_DEATHLETTER_DEATHDATE %>" value="<%=null!=ubn?Utilities.showStringValue(Utilities.dateToString(ubn.getDeathDate(), TransConstants.DATE_HTML_SHORT_PATTERN)):""%>">
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(TransConstants.FORM_TRANS_DEATHLETTER_DEATHDATE):""%></span>
        </div>
      </fieldset>
      <fieldset>
        <div class="full">
          <label>Note</label>
          <textarea rows="5" cols="50" name="<%=TransConstants.FORM_TRANS_DEATHLETTER_NOTE%>"><%=null!=ubn?Utilities.showStringValue(ubn.getNote()):""%></textarea>
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(TransConstants.FORM_TRANS_DEATHLETTER_NOTE):""%></span>
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