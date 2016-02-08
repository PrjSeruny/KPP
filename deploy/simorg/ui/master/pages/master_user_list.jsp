<%@page import=" java.io.*,
               com.sync.core.utils.Constants,
               com.sync.master.utils.MasterConstants,
               com.sync.core.beans.MessageBean,
               com.sync.core.utils.Utilities,
               com.sync.master.beans.MasterUserBean"
%>
<%
   String act = (String)request.getAttribute(MasterConstants.ACT);
   MasterUserBean[] list = (MasterUserBean[]) request.getAttribute(MasterConstants.USER_LIST);
   MasterUserBean ubn = (MasterUserBean)request.getAttribute(MasterConstants.USER_INFO);
   MessageBean msg = null;
   String type="";
   System.out.println(">>>>>>>>>>>>> JSP ACTION= "+act);
   if(null!=ubn)
   {
     msg = ubn.getMessageBean();
   }
   
   if(null==ubn){  act = MasterConstants.ACT_CREATE; }
%>
<html>
<body>
<table>
<tr><td><jsp:include page="<%=Constants.HOME_PAGE%>" flush="true"/></td></tr>
<tr>
  <td valign="top">
     <form name="create" method="post" action="<%=Constants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>">
     <input type="hidden" name="<%=MasterConstants.W%>" value="<%=MasterConstants.MASTERUSER%>">
     <input type="hidden" name="<%=MasterConstants.ACT%>" value="<%=act%>">
     <table border="1">
         <tr>
            <td>UserID:</td>
            <td>
<%
   if(!Utilities.isEmpy(act) && act.equals(MasterConstants.ACT_CREATE)) type = "text";
   else type="hidden";
%>            
               <input type="<%=type%>" name="<%=MasterConstants.FORM_MASTERUSER_USERID%>" value="<%=null!=ubn?ubn.getUser():""%>">
<%
   if(!Utilities.isEmpy(act) && act.equals(MasterConstants.ACT_UPDATE_SAVE))
   {
     out.println(ubn.getUser());
   }
%>               
               <%=null!=msg && null!=msg.getMessageBean(MasterConstants.FORM_MASTERUSER_USERID)?msg.getMessageBean(MasterConstants.FORM_MASTERUSER_USERID):""%>
            </td>
         </tr>
         <tr>
            <td>Nama:</td>
            <td>
              <input type="text" name="<%=MasterConstants.FORM_MASTERUSER_NAME%>" value="<%=null!=ubn?ubn.getName():""%>">
              <%=null!=msg && null!=msg.getMessageBean(MasterConstants.FORM_MASTERUSER_NAME)?msg.getMessageBean(MasterConstants.FORM_MASTERUSER_NAME):""%>
            </td>
         </tr>
         <tr>
            <td>Kata Sandi:</td>
            <td>
              <input type="password" name="<%=MasterConstants.FORM_MASTERUSER_PASSWD%>" value="">
              <%=null!=msg && null!=msg.getMessageBean(MasterConstants.FORM_MASTERUSER_PASSWD)?msg.getMessageBean(MasterConstants.FORM_MASTERUSER_PASSWD):""%>
            </td>
         </tr>
     </table>
     <button type="submit" value="Simpan">Simpan</button>&nbsp;
<%
if(!Utilities.isEmpy(act) && act.equals(MasterConstants.ACT_CREATE))
{
%>     
     <button type="reset" value="Reset">Reset</button>
<%
}
else
{
%>
     <button type="submit" name="<%=MasterConstants.BTN_CANCEL%>" value="<%=MasterConstants.BTN_CANCEL%>" >Batal</button>&nbsp;
<%  
}
%>
     </form>
  </td>
</tr>
<tr>
  <td valign="top"> 
    <table>
     <tr><td valign="top">Daftar User:</td></tr>
<%
   if(null!=list && list.length>0)
   {
%>
      <tr>
       <td valign="top">
           <table border="1">
               <tr>
                 <td valign="top">UserID</td>
                 <td valign="top">Nama</td>
               </tr>
<%
      for(int i=0; i<list.length; i++)
      {
%>
         <tr>
           <td valign="top"><a href="<%=MasterConstants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>?<%=MasterConstants.W%>=<%=MasterConstants.MASTERUSER %>&<%=MasterConstants.ACT%>=<%=MasterConstants.ACT_VIEW%>&<%=MasterConstants.FORM_MASTERUSER_USERID%>=<%=list[i].getUser()%>"><%=list[i].getUser()%></a></td>
           <td valign="top"><%=list[i].getName()%></td>
         </tr>
<%        
      }
%>               
           </table>
       </td>
      </tr>
<%     
   }
   else
   {
     out.println("Tidak ada data user dalam database.");
   }
%>     
  </table>
  </td>
</tr>
</table>
</body>
</html>