<%@page import="com.sync.master.utils.MasterTable"%>
<%@page import="com.sync.master.pool.LevelAccessPool"%>
<%@page import="com.sync.trans.utils.TransConstants"%>
<%@page import="com.sync.master.beans.LevelAccessBean"%>
<%@page import=" java.io.*,
               com.sync.core.utils.Constants,
               com.sync.master.utils.MasterConstants,
               com.sync.core.beans.MessageBean,
               com.sync.core.utils.Utilities,
               com.sync.master.beans.MasterUserBean,
               com.sync.master.beans.MasterLevelAccessBean"
%>
<%
MasterLevelAccessBean[] levelAccess = (MasterLevelAccessBean[])request.getAttribute(MasterConstants.MASTERLEVEL_LIST);
LevelAccessPool lp = LevelAccessPool.getInstance();
String LevelID = (String)request.getAttribute(MasterConstants.FORM_MASTERUSER_LEVEL);
if(null==LevelID) LevelID = "ADMIN";
%>
<script>
$(document).ready(function(){
	$('.levelID').change(function(){
		SelectedVal = $(this).val();
		URL = "<%=Constants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>?<%=Constants.W%>=<%=MasterConstants.LEVELACCESS%>&<%=MasterConstants.FORM_MASTERUSER_LEVEL%>=" + SelectedVal;
		window.location = URL;
	});
});
</script>
<fieldset class="wrapper">
<form method="post" action="<%=MasterConstants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>">
<input type="hidden" name="<%=MasterConstants.W%>" value="<%=MasterConstants.LEVELACCESS%>">
<input type="hidden" name="<%=MasterConstants.ACT%>" value="<%=MasterConstants.ACT_CREATE%>">
<table border="0">
<tr>
	<td>
		<label>Level ID</label>
		<select name="<%=MasterConstants.FORM_MASTERUSER_LEVEL%>" class="levelID">
			<%
			if(null!=levelAccess)
			{
				for(int j = 0; j < levelAccess.length; j++)
				{
					%>
					<option value="<%=null!=levelAccess[j]?levelAccess[j].getID():""%>" <%=levelAccess[j].getID().equals(LevelID)?"selected":""%>><%=null!=levelAccess[j]?levelAccess[j].getName():"" %></option>
					<%
				}
			}
			%>
		</select>
	</td>
	<td><input type="submit" value="Save"></td>
</tr>
<tr>
	<td colspan="2">
		<table border="0">
			<tr class="print" bgcolor="#FFCC99">
	      <td class="print" align="center" valign="top">&nbsp;</td>
	      <td class="print" align="center" valign="top" width="30"><b>L</b></td>
	      <td class="print" align="center" valign="top" width="30"><b>I</b></td>
	      <td class="print" align="center" valign="top" width="30"><b>C</b></td>
	      <td class="print" align="center" valign="top" width="30"><b>U</b></td>
	      <td class="print" align="center" valign="top" width="30"><b>D</b></td>
	    </tr>
	    <tr class="print" bgcolor="#FFCCFF">
	      <td class="print" valign="top" width="250"><b>Public Settings</b></td>
	      <td class="print" align="center" valign="top"></td>
	      <td class="print" align="center" valign="top"></td>
	      <td class="print" align="center" valign="top">&nbsp;</td>
	      <td class="print" align="center" valign="top">&nbsp;</td>
	      <td class="print" align="center" valign="top">&nbsp;</td>
	    </tr>
	    <tr class="print" bgcolor="#FFCCCC">
	      <td class="print" valign="top" width="250"><b>Gambar Slide</b></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=Constants.SLIDE_SETTING_PRM %>" value="<%=LevelAccessBean.PERMIT_LIST%>" <%=lp.checkValidate(LevelID, Constants.SLIDE_SETTING_PRM, LevelAccessBean.PERMIT_LIST)?"checked":""%>/></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=Constants.SLIDE_SETTING_PRM %>" value="<%=LevelAccessBean.PERMIT_INFO%>" <%=lp.checkValidate(LevelID, Constants.SLIDE_SETTING_PRM, LevelAccessBean.PERMIT_INFO)?"checked":""%>/></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=Constants.SLIDE_SETTING_PRM %>" value="<%=LevelAccessBean.PERMIT_CREATE%>" <%=lp.checkValidate(LevelID, Constants.SLIDE_SETTING_PRM, LevelAccessBean.PERMIT_CREATE)?"checked":""%>/></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=Constants.SLIDE_SETTING_PRM %>" value="<%=LevelAccessBean.PERMIT_UPDATE%>" <%=lp.checkValidate(LevelID, Constants.SLIDE_SETTING_PRM, LevelAccessBean.PERMIT_UPDATE)?"checked":""%>/></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=Constants.SLIDE_SETTING_PRM %>" value="<%=LevelAccessBean.PERMIT_DELETE%>" <%=lp.checkValidate(LevelID, Constants.SLIDE_SETTING_PRM, LevelAccessBean.PERMIT_DELETE)?"checked":""%>/></td>
	    </tr>
	    <tr class="print" bgcolor="#FFCCCC">
	      <td class="print" valign="top" width="250"><b>Gallery Foto</b></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=Constants.GALLERY_SETTING_PRM %>" value="<%=LevelAccessBean.PERMIT_LIST%>" <%=lp.checkValidate(LevelID, Constants.GALLERY_SETTING_PRM, LevelAccessBean.PERMIT_LIST)?"checked":""%>/></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=Constants.GALLERY_SETTING_PRM %>" value="<%=LevelAccessBean.PERMIT_INFO%>" <%=lp.checkValidate(LevelID, Constants.GALLERY_SETTING_PRM, LevelAccessBean.PERMIT_INFO)?"checked":""%>/></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=Constants.GALLERY_SETTING_PRM %>" value="<%=LevelAccessBean.PERMIT_CREATE%>" <%=lp.checkValidate(LevelID, Constants.GALLERY_SETTING_PRM, LevelAccessBean.PERMIT_CREATE)?"checked":""%>/></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=Constants.GALLERY_SETTING_PRM %>" value="<%=LevelAccessBean.PERMIT_UPDATE%>" <%=lp.checkValidate(LevelID, Constants.GALLERY_SETTING_PRM, LevelAccessBean.PERMIT_CREATE)?"checked":""%>/></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=Constants.GALLERY_SETTING_PRM %>" value="<%=LevelAccessBean.PERMIT_DELETE%>" <%=lp.checkValidate(LevelID, Constants.GALLERY_SETTING_PRM, LevelAccessBean.PERMIT_DELETE)?"checked":""%>/></td>
	    </tr>
	    <tr class="print" bgcolor="#FFFFFF">
	      <td valign="top" height="2" colspan="9">&nbsp;</td>
	    </tr>
	    <tr class="print" bgcolor="#FFCCFF">
	      <td class="print" valign="top" width="250"><b>Master</b></td>
	      <td class="print" align="center" valign="top"></td>
	      <td class="print" align="center" valign="top"></td>
	      <td class="print" align="center" valign="top">&nbsp;</td>
	      <td class="print" align="center" valign="top">&nbsp;</td>
	      <td class="print" align="center" valign="top">&nbsp;</td>
	    </tr>
	    <tr class="print" bgcolor="#FFCCCC">
	      <td class="print" valign="top" width="250"><b>Master User</b></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=MasterConstants.MASTERUSER %>" value="<%=LevelAccessBean.PERMIT_LIST%>" <%=lp.checkValidate(LevelID, MasterConstants.MASTERUSER, LevelAccessBean.PERMIT_LIST)?"checked":""%>/></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=MasterConstants.MASTERUSER %>" value="<%=LevelAccessBean.PERMIT_INFO%>" <%=lp.checkValidate(LevelID, MasterConstants.MASTERUSER, LevelAccessBean.PERMIT_INFO)?"checked":""%>/></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=MasterConstants.MASTERUSER %>" value="<%=LevelAccessBean.PERMIT_CREATE%>" <%=lp.checkValidate(LevelID, MasterConstants.MASTERUSER, LevelAccessBean.PERMIT_CREATE)?"checked":""%>/></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=MasterConstants.MASTERUSER %>" value="<%=LevelAccessBean.PERMIT_UPDATE%>" <%=lp.checkValidate(LevelID, MasterConstants.MASTERUSER, LevelAccessBean.PERMIT_UPDATE)?"checked":""%>/></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=MasterConstants.MASTERUSER %>" value="<%=LevelAccessBean.PERMIT_DELETE%>" <%=lp.checkValidate(LevelID, MasterConstants.MASTERUSER, LevelAccessBean.PERMIT_DELETE)?"checked":""%>/></td>
	    </tr>
	    <tr class="print" bgcolor="#FFCCCC">
	      <td class="print" valign="top" width="250"><b>Master Region</b></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=MasterConstants.MASTER_REGION %>" value="<%=LevelAccessBean.PERMIT_LIST%>" <%=lp.checkValidate(LevelID, MasterConstants.MASTER_REGION, LevelAccessBean.PERMIT_LIST)?"checked":""%>/></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=MasterConstants.MASTER_REGION %>" value="<%=LevelAccessBean.PERMIT_INFO%>" <%=lp.checkValidate(LevelID, MasterConstants.MASTER_REGION, LevelAccessBean.PERMIT_INFO)?"checked":""%>/></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=MasterConstants.MASTER_REGION %>" value="<%=LevelAccessBean.PERMIT_CREATE%>" <%=lp.checkValidate(LevelID, MasterConstants.MASTER_REGION, LevelAccessBean.PERMIT_CREATE)?"checked":""%>/></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=MasterConstants.MASTER_REGION %>" value="<%=LevelAccessBean.PERMIT_UPDATE%>" <%=lp.checkValidate(LevelID, MasterConstants.MASTER_REGION, LevelAccessBean.PERMIT_UPDATE)?"checked":""%>/></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=MasterConstants.MASTER_REGION %>" value="<%=LevelAccessBean.PERMIT_DELETE%>" <%=lp.checkValidate(LevelID, MasterConstants.MASTER_REGION, LevelAccessBean.PERMIT_DELETE)?"checked":""%>/></td>
	    </tr>
	    <tr class="print" bgcolor="#FFCCCC">
	      <td class="print" valign="top" width="250"><b>Master Penduduk</b></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=MasterConstants.MASTER_RESIDENT %>" value="<%=LevelAccessBean.PERMIT_LIST%>" <%=lp.checkValidate(LevelID, MasterConstants.MASTER_RESIDENT, LevelAccessBean.PERMIT_LIST)?"checked":""%>/></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=MasterConstants.MASTER_RESIDENT %>" value="<%=LevelAccessBean.PERMIT_INFO%>" <%=lp.checkValidate(LevelID, MasterConstants.MASTER_RESIDENT, LevelAccessBean.PERMIT_INFO)?"checked":""%>/></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=MasterConstants.MASTER_RESIDENT %>" value="<%=LevelAccessBean.PERMIT_CREATE%>" <%=lp.checkValidate(LevelID, MasterConstants.MASTER_RESIDENT, LevelAccessBean.PERMIT_CREATE)?"checked":""%>/></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=MasterConstants.MASTER_RESIDENT %>" value="<%=LevelAccessBean.PERMIT_UPDATE%>" <%=lp.checkValidate(LevelID, MasterConstants.MASTER_RESIDENT, LevelAccessBean.PERMIT_UPDATE)?"checked":""%>/></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=MasterConstants.MASTER_RESIDENT %>" value="<%=LevelAccessBean.PERMIT_DELETE%>" <%=lp.checkValidate(LevelID, MasterConstants.MASTER_RESIDENT, LevelAccessBean.PERMIT_DELETE)?"checked":""%>/></td>
	    </tr>
	    <tr class="print" bgcolor="#FFCCCC">
	      <td class="print" valign="top" width="250"><b>Master Level Access</b></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=MasterConstants.MASTER_LEVEL_ACCESS %>" value="<%=LevelAccessBean.PERMIT_LIST%>"/></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=MasterConstants.MASTER_LEVEL_ACCESS %>" value="<%=LevelAccessBean.PERMIT_INFO%>"/></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=MasterConstants.MASTER_LEVEL_ACCESS %>" value="<%=LevelAccessBean.PERMIT_CREATE%>"/></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=MasterConstants.MASTER_LEVEL_ACCESS %>" value="<%=LevelAccessBean.PERMIT_UPDATE%>"/></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=MasterConstants.MASTER_LEVEL_ACCESS %>" value="<%=LevelAccessBean.PERMIT_DELETE%>"/></td>
	    </tr>
	    <tr class="print" bgcolor="#FFCCCC">
	      <td class="print" valign="top" width="250"><b>Level Access</b></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=MasterConstants.LEVELACCESS %>" value="<%=LevelAccessBean.PERMIT_LIST%>"/></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=MasterConstants.LEVELACCESS %>" value="<%=LevelAccessBean.PERMIT_INFO%>"/></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=MasterConstants.LEVELACCESS %>" value="<%=LevelAccessBean.PERMIT_CREATE%>"/></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=MasterConstants.LEVELACCESS %>" value="<%=LevelAccessBean.PERMIT_UPDATE%>"/></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=MasterConstants.LEVELACCESS %>" value="<%=LevelAccessBean.PERMIT_DELETE%>"/></td>
	    </tr>
 	    <tr class="print" bgcolor="#FFFFFF">
     		<td valign="top" height="2" colspan="9">&nbsp;</td>
	    </tr>
	    <tr class="print" bgcolor="#FFCCFF">
	      <td class="print" valign="top" width="250"><b>Transaksi</b></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=MasterConstants.LEVELACCESS %>" value="<%=LevelAccessBean.PERMIT_LIST%>"/></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=MasterConstants.LEVELACCESS %>" value="<%=LevelAccessBean.PERMIT_INFO%>"/></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=MasterConstants.LEVELACCESS %>" value="<%=LevelAccessBean.PERMIT_CREATE%>"/></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=MasterConstants.LEVELACCESS %>" value="<%=LevelAccessBean.PERMIT_UPDATE%>"/></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=MasterConstants.LEVELACCESS %>" value="<%=LevelAccessBean.PERMIT_DELETE%>"/></td>
	    </tr>
	    <tr class="print" bgcolor="#FFCCCC">
	      <td class="print" valign="top" width="250"><b>Mutasi KK</b></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=TransConstants.TRANS_FAMILYCARDMUT %>" value="<%=LevelAccessBean.PERMIT_LIST%>"/></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=TransConstants.TRANS_FAMILYCARDMUT %>" value="<%=LevelAccessBean.PERMIT_INFO%>"/></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=TransConstants.TRANS_FAMILYCARDMUT %>" value="<%=LevelAccessBean.PERMIT_CREATE%>"/></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=TransConstants.TRANS_FAMILYCARDMUT %>" value="<%=LevelAccessBean.PERMIT_UPDATE%>"/></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=TransConstants.TRANS_FAMILYCARDMUT %>" value="<%=LevelAccessBean.PERMIT_DELETE%>"/></td>
	    </tr>
	    <tr class="print" bgcolor="#FFCCCC">
	      <td class="print" valign="top" width="250"><b>Daftar Kelahiran</b></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=TransConstants.TRANS_BIRTHLETTER %>" value="<%=LevelAccessBean.PERMIT_LIST%>"/></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=TransConstants.TRANS_BIRTHLETTER %>" value="<%=LevelAccessBean.PERMIT_INFO%>"/></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=TransConstants.TRANS_BIRTHLETTER %>" value="<%=LevelAccessBean.PERMIT_CREATE%>"/></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=TransConstants.TRANS_BIRTHLETTER %>" value="<%=LevelAccessBean.PERMIT_UPDATE%>"/></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=TransConstants.TRANS_BIRTHLETTER %>" value="<%=LevelAccessBean.PERMIT_DELETE%>"/></td>
	    </tr>
	    <tr class="print" bgcolor="#FFCCCC">
	      <td class="print" valign="top" width="250"><b>Daftar Kematian</b></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=TransConstants.TRANS_DEATHLETTER %>" value="<%=LevelAccessBean.PERMIT_LIST%>"/></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=TransConstants.TRANS_DEATHLETTER %>" value="<%=LevelAccessBean.PERMIT_INFO%>"/></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=TransConstants.TRANS_DEATHLETTER %>" value="<%=LevelAccessBean.PERMIT_CREATE%>"/></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=TransConstants.TRANS_DEATHLETTER %>" value="<%=LevelAccessBean.PERMIT_UPDATE%>"/></td>
	      <td class="print" align="center" valign="top"><input type="checkbox" name="<%=TransConstants.TRANS_DEATHLETTER %>" value="<%=LevelAccessBean.PERMIT_DELETE%>"/></td>
	    </tr>
 	    <tr class="print" bgcolor="#FFFFFF">
     		<td valign="top" height="2" colspan="9">&nbsp;</td>
	    </tr>
	    <tr class="print" bgcolor="#FFCCFF">
	      <td class="print" valign="top" width="250"><b>Lapora</b></td>
	      <td class="print" align="center" valign="top"></td>
	      <td class="print" align="center" valign="top"></td>
	      <td class="print" align="center" valign="top">&nbsp;</td>
	      <td class="print" align="center" valign="top">&nbsp;</td>
	      <td class="print" align="center" valign="top">&nbsp;</td>
	    </tr>
	    <tr class="print" bgcolor="#FFCCCC">
	      <td class="print" valign="top" width="250"><b>Laporan Kependudukan</b></td>
	      <td class="print" align="center" valign="top"></td>
	      <td class="print" align="center" valign="top"></td>
	      <td class="print" align="center" valign="top">&nbsp;</td>
	      <td class="print" align="center" valign="top">&nbsp;</td>
	      <td class="print" align="center" valign="top">&nbsp;</td>
	    </tr>
		</table>
	</td>
</tr>
</table>
</form>
</fieldset>