<%@page import=" java.io.*,
               com.sync.core.utils.Constants,
               com.sync.master.utils.MasterConstants,
               com.sync.core.beans.MessageBean,
               com.sync.core.utils.Utilities,
               com.sync.master.beans.MasterUserBean,
               com.sync.master.beans.MasterLevelAccessBean"
%>
<%
MasterLevelAccessBean bn = (MasterLevelAccessBean)request.getAttribute(MasterConstants.MASTERLEVEL_INFO);
MessageBean msg = null;
String type = "";
if(null!=bn && bn.getMessageBean().anyMessageExist())
{
	msg = bn.getMessageBean();
}

%><fieldset class="wrapper">
<form method="post" action="<%=MasterConstants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>">
<input type="hidden" name="<%=MasterConstants.W%>" value="<%=MasterConstants.MASTER_LEVEL_ACCESS%>">
<input type="hidden" name="<%=MasterConstants.ACT%>" value="<%=MasterConstants.ACT_CREATE%>">
<div class="form">
<h2 class="title">Tambah User Access Level</h2>
<label class="errormsg"><%=null!=msg?msg.showMessage(MasterConstants.ERRORMSG_PAGE):""%></label>
<fieldset>
  <div>
    <label>Level ID</label>
    <input type="text" name="<%=MasterConstants.FORM_MASTERUSERLEVELACCESS_LEVELID %>" value="<%=null!=bn?Utilities.showStringValue(bn.getID()):""%>">
    <br><span class="erroritm"><%=null!=msg?msg.showMessage(MasterConstants.FORM_MASTERUSERLEVELACCESS_LEVELID):""%></span>
  </div>
  <div>
    <label>Level Name</label>
    <input type="text" name="<%=MasterConstants.FORM_MASTERUSERLEVELACCESS_NAME %>" value="<%=null!=bn?Utilities.showStringValue(bn.getName()):""%>">
    <br><span class="erroritm"><%=null!=msg?msg.showMessage(MasterConstants.FORM_MASTERUSERLEVELACCESS_NAME):""%></span>
  </div>
</fieldset>
<fieldset>
  <div>
    <label>Level Note</label>
    <input type="text" name="<%=MasterConstants.FORM_MASTERUSERLEVELACCESS_NOTE %>" value="<%=null!=bn?Utilities.showStringValue(bn.getNote()):""%>">
    <br><span class="erroritm"><%=null!=msg?msg.showMessage(MasterConstants.FORM_MASTERUSERLEVELACCESS_NOTE):""%></span>
  </div>
</fieldset>
<fieldset>
  <div>
    <input type="submit" value="Simpan"><input type="reset" value="Reset" class="negate">
  </div>
</fieldset>
</div>
</form>
</fieldset>

<!-- LIST DATA MASTER ACCESS LEVEL -->
<fieldset class="wrapper">
<div class="form" style="clear:left">
	<h2 class="title">Daftar Level Access</h2>
	<form method="post" class="ajax-form" dst="userlist" id="userlist" 
    action="<%=Constants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>?<%=Constants.W%>=<%=MasterConstants.MASTER_LEVEL_ACCESS%>">

      <jsp:include page="<%=MasterConstants.MASTER_LEVELACCESS_LIST%>" flush="true"/>

  </form>
</div>
</fieldset>