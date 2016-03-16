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
System.out.println(ubn);
	if(null!=ubn && null!=ubn.getMessageBean() && ubn.getMessageBean().anyMessageExist())
	{
	  msg = ubn.getMessageBean();
	}

%>
<fieldset class="wrapper">
  <form method="post" action="<%=MasterConstants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>">
    <input type="hidden" name="<%=MasterConstants.W%>" value="<%=MasterConstants.MASTERUSER%>">
    <input type="hidden" name="<%=MasterConstants.ACT%>" value="<%=MasterConstants.ACT_UPDATE%>">
    <div class="form">
      <h2 class="title">Ubah User</h2>
      <label class="errormsg"><%=null!=msg?msg.showMessage(MasterConstants.ERRORMSG_PAGE):""%></label>
      <fieldset>
        <div>
          <label>Username</label>
          <input type="hidden" name="<%=MasterConstants.FORM_MASTERUSER_USERID %>" value="<%=null!=ubn?Utilities.showStringValue(ubn.getUser()):""%>">
          <input type="text" value="<%=null!=ubn?Utilities.showStringValue(ubn.getUser()):""%>" readonly disabled>
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(MasterConstants.FORM_MASTERUSER_USERID):""%></span>
        </div>
        <div>
          <label>Nama Lengkap</label>
          <input type="text" name="<%=MasterConstants.FORM_MASTERUSER_NAME %>" value="<%=null!=ubn?Utilities.showStringValue(ubn.getName()):""%>">
          <br><span class="erroritm"><%=null!=msg?msg.showMessage(MasterConstants.FORM_MASTERUSER_NAME):""%></span>
        </div>
        <div>
          <label>Level ID</label>
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
          <input type="submit" name="<%=MasterConstants.BTN_SAVE %>" value="Simpan">
          <input type="submit" name="<%=MasterConstants.BTN_CANCEL %>" value="Batal" class="negate">
        </div>
      </fieldset>
    </div>
  </form>
</fieldset>