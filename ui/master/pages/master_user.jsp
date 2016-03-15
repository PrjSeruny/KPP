<%@page import="com.sync.master.beans.MasterLevelAccessBean"%>
<%@page import=" java.io.*,
               com.sync.core.utils.Constants,
               com.sync.master.utils.MasterConstants,
               com.sync.core.beans.MessageBean,
               com.sync.core.utils.Utilities,
               com.sync.master.beans.MasterUserBean"
%>
<%
   MasterUserBean ubn = (MasterUserBean)request.getAttribute(MasterConstants.USER_INFO);
	 MasterLevelAccessBean[] levelAccess = (MasterLevelAccessBean[])request.getAttribute(MasterConstants.MASTERLEVEL_LIST);
   MessageBean msg = null;
   String type="";
   if(null!=ubn && ubn.getMessageBean().anyMessageExist())
   {
     msg = ubn.getMessageBean();
   }
   
%>
<fieldset class="wrapper">
  <form method="post" action="<%=MasterConstants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>">
    <input type="hidden" name="<%=MasterConstants.W%>" value="<%=MasterConstants.MASTERUSER%>">
    <input type="hidden" name="<%=MasterConstants.ACT%>" value="<%=MasterConstants.ACT_CREATE%>">
    <div class="form">
      <h2 class="title">Tambah User</h2>
      <label class="errormsg"><%=null!=msg?msg.showMessage(MasterConstants.ERRORMSG_PAGE):""%></label>
      <fieldset>
        <div>
          <label>Nama Lengkap</label>
          <input type="text" name="<%=MasterConstants.FORM_MASTERUSER_NAME %>" value="<%=null!=ubn?Utilities.showStringValue(ubn.getName()):""%>">
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(MasterConstants.FORM_MASTERUSER_NAME):""%></span>
        </div>
      </fieldset>
      <fieldset>
        <div>
          <label>Username</label>
          <input type="text" name="<%=MasterConstants.FORM_MASTERUSER_USERID %>" value="<%=null!=ubn?Utilities.showStringValue(ubn.getUser()):""%>">
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(MasterConstants.FORM_MASTERUSER_USERID):""%></span>
        </div>
        <div>
          <label>Password</label>
          <input type="password" name="<%=MasterConstants.FORM_MASTERUSER_PASSWD %>">
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(MasterConstants.FORM_MASTERUSER_PASSWD):""%></span>
        </div>
      </fieldset>
      <fieldset>
      	<div>
      		<label>Level Access</label>
      		<select name="<%=MasterConstants.FORM_MASTERUSER_LEVEL%>">
      			<option value="N/A">Pilih Level</option>
      			<%
      			if(null!=levelAccess)
      			{
      				for(int j = 0; j < levelAccess.length; j++)
      				{
      					%>
      					<option value="<%=null!=levelAccess[j]?levelAccess[j].getID():""%>"><%=null!=levelAccess[j]?levelAccess[j].getName():"" %></option>
      					<%
      				}
      			}
      			%>
      		</select>
      		<br><span class="erroritm"><%=null!=msg?msg.showMessage(MasterConstants.FORM_MASTERUSER_LEVEL):""%></span>
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

<fieldset class="wrapper">
  <div class="form" style="clear:left">
    <h2 class="title">Daftar User</h2>
    <form method="post" class="ajax-form" dst="userlist" id="userlist" 
      action="<%=Constants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>?<%=Constants.W%>=<%=MasterConstants.MASTERUSER%>">

        <jsp:include page="<%=MasterConstants.MASTER_USER_LIST%>" flush="true"/>

    </form>
  </div>
</fieldset>
