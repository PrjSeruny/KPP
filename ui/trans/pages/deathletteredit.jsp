<%@page import="com.sync.master.utils.MasterConstants"%>
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
   String genmsg ="";
   if(null!=ubn)
   {
     msg = ubn.getBeanMessage();
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
     <input type="hidden" name="<%=TransConstants.W%>" value="<%=TransConstants.TRANS_DEATHLETTER%>">
     <input type="hidden" name="<%=TransConstants.ACT%>" value="<%=act%>">
    <div class="form">
      <h2 class="title">Surat Kematian</h2>
      <label class="errormsg"><%=null!=msg?msg.showMessage(TransConstants.ERRORMSG_PAGE):""%></label>
      <fieldset>
        <div>
          <label><font color="red">#</font>NIK</label>
          <a href="javascript:void(0)" 
          class="lookup"
          valTarget="#userIDVal;#userNameVal"
          param="width=450;height=300"
          url="<%=Constants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>?<%=Constants.W%>=<%=MasterConstants.MASTER_RESIDENT%>&<%=MasterConstants.ACT%>=<%=MasterConstants.ACT_LOOKUP%>&<%=MasterConstants.LOOKUP_SINGLE%>=1">Cari</a>
<%
   if(!Utilities.isEmpy(act) && act.equals(TransConstants.ACT_UPDATE_SAVE)) type = "hidden";
   else type="text";
%>            
               <input type="<%=type%>" id="userIDVal" name="<%=TransConstants.FORM_TRANS_DEATHLETTER_NIK%>" value="<%=null!=ubn?Utilities.showStringValue(ubn.getNIK()):""%>" readonly="readonly">
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
          <label><font color="red">#</font>Nama</label>
          <input type="text" id="userNameVal" name="<%=TransConstants.FORM_TRANS_DEATHLETTER_NAME %>" value="<%=null!=ubn?Utilities.showStringValue(ubn.getName()):""%>" readonly="readonly">
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(TransConstants.FORM_TRANS_DEATHLETTER_NAME):""%></span>
        </div>
        <div >
          <label><font color="red">#</font>Tanggal Kematian</label>
          <input type="text" class="date" name="<%=TransConstants.FORM_TRANS_DEATHLETTER_DEATHDATE %>" value="<%=null!=ubn?Utilities.showStringValue(Utilities.dateToString(ubn.getDeathDate(), TransConstants.DATE_HTML_SHORT_PATTERN)):""%>">
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