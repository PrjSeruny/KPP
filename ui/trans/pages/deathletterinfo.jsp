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
   String tmp="";
   System.out.println(">>>>>>>>>>>>> JSP ACTION= "+act);
   String genmsg ="";
   if(null!=ubn)
   {
     msg = ubn.getBeanMessage();
     if(null!=msg)
     {
       genmsg = msg.getMessageBean(MessageBean.MSG_ERR);
     }
   }
   
%>

<fieldset class="wrapper">
<%
   if(!Utilities.isEmpy(genmsg))
   {
     out.println(genmsg);
   }
%>
 <form name="info" method="post" action="<%=Constants.ROOT_PATH%><%=TransConstants.SVT_TRANS_PATH%>">
 <input type="hidden" name="<%=TransConstants.W%>" value="<%=TransConstants.TRANS_DEATHLETTER%>">
 <input type="hidden" name="<%=TransConstants.ACT%>" value="<%=TransConstants.ACT_UPDATE%>">
    <div class="form">
        <h2 class="title">Info Surat Kematian</h2>
        <fieldset>
            <div >
                <table  style="float:left;margin-right:20px">
                 <tr>
                    <td class="bold" width="150px">NIK</td>
                    <td>
                        :<%=null!=ubn?ubn.getNIK():""%>
                       <input type="hidden" name="<%=TransConstants.FORM_TRANS_DEATHLETTER_NIK%>" value="<%=null!=ubn?ubn.getNIK():""%>">
                    </td>
                 </tr>
                 <tr>
                    <td class="bold">Nama</td>
                    <td>: <%=null!=ubn?ubn.getName():""%></td>
                 </tr>
                 <tr>
                    <td class="bold">Tgl Kematian</td>
                    <td>: <%=null!=ubn?Utilities.dateToString(ubn.getDeathDate(), TransConstants.DATE_HTML_SHORT_PATTERN) :""%></td>
                 </tr>
                 <tr>
                    <td class="bold">Catatan</td>
                    <td>: <%=null!=ubn&&!Utilities.isEmpy(ubn.getNote())?ubn.getNote():""%></td>
                 </tr>
             </table>

            </div>
        </fieldset>
        <fieldset><div>
            <input type="submit" name="<%=TransConstants.BTN_DONE %>" value="Selesai" class="negate">
            <input type="submit" value="Ubah">
<%
    System.out.println("user prosess= "+ubn.getProcessUser() + " user date="+ubn.getProcessDate());
    if(Utilities.isEmpy(ubn.getProcessUser()) && null==ubn.getProcessDate())
    {
%>            
            <input type="submit" name="<%=TransConstants.BTN_PROC%>" value="Proses">
<%
    }
    else if(!Utilities.isEmpy(ubn.getProcessUser()) && null!=ubn.getProcessDate())
    {
%>
           <input type="submit" name="<%=TransConstants.BTN_CANCELPROC%>" value="Batal Proses">
<%      
    }
%>            
        </div></fieldset>
    </div>
 </form>
</fieldset>