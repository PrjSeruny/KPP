<%@page import="com.sync.trans.utils.TransConstants"%>
<%@page import="com.sync.trans.beans.FamilyCardMutationBean"%>
<%@page import=" java.io.*,
               com.sync.core.utils.Constants,
               com.sync.trans.utils.TransConstants,
               com.sync.core.beans.MessageBean,
               com.sync.core.utils.Utilities,
               com.sync.master.beans.MasterUserBean"
%>
<%
   String act = (String)request.getAttribute(TransConstants.ACT);
   FamilyCardMutationBean ubn = (FamilyCardMutationBean)request.getAttribute(TransConstants.FAMILYCARDMUT_INFO);
   MessageBean msg = null;
   String type="";
   String tmp="";
   System.out.println(">>>>>>>>>>>>> JSP ACTION= "+act);
   if(null!=ubn)
   {
     msg = ubn.getBeanMessages();
   }
   
%>
<fieldset class="wrapper">
 <a href="<%=Constants.ROOT_PATH%><%=TransConstants.SVT_TRANS_PATH%>?<%=Constants.W%>=<%=TransConstants.TRANS_FAMILYCARDMUT%>&<%=TransConstants.ACT%>=<%=TransConstants.ACT_CREATE%>" class="add" title="Tambah" >Tambah</a>
 <form name="info" method="post" action="<%=Constants.ROOT_PATH%><%=TransConstants.SVT_TRANS_PATH%>">
 <input type="hidden" name="<%=TransConstants.W%>" value="<%=TransConstants.TRANS_FAMILYCARDMUT%>">
 <input type="hidden" name="<%=TransConstants.ACT%>" value="<%=TransConstants.ACT_UPDATE%>">
    <div class="form">
        <h2 class="title">Info Mutasi KK</h2>
        <fieldset>
            <div >
                <table border="0" style="float:left;margin-right:20px">
                 <tr>
                    <td class="bold" width="150px">NIK</td>
                    <td>
                        : <%=null!=ubn?ubn.getNIK():""%>
                       <input type="hidden" name="<%=TransConstants.FORM_FAMILYCARDMUT_NIK%>" value="<%=null!=ubn?ubn.getNIK():""%>">
                    </td>
                 </tr>
                 <tr>
                    <td class="bold">Nama</td>
                    <td>: <%=null!=ubn?ubn.getName():""%></td>
                 </tr>
                 <tr>
                    <td class="bold">Tgl Berlaku KK Baru</td>
                    <td>: <%=null!=ubn? Utilities.dateToString(ubn.getStartDate(), TransConstants.DATE_HTML_SHORT_PATTERN) :""%>
                       <input type="hidden" name="<%=TransConstants.FORM_FAMILYCARDMUT_STARTDATE%>" value="<%=null!=ubn? Utilities.dateToString(ubn.getStartDate(), TransConstants.DATE_HTML_SHORT_PATTERN) :""%>">
                   </td>
                 </tr>
                 <tr>
                    <td class="bold">KK Lama</td>
                    <td>: <%=null!=ubn?ubn.getOldKK():""%></td>
                 </tr>
                 <tr>
                    <td class="bold">KK Baru</td>
                    <td>: <%=null!=ubn?ubn.getNewKK():""%></td>
                 </tr>
                 <tr>
                    <td class="bold">Jenis Kelamin</td>
                    <td>: <%=null!=ubn&&ubn.getSex()==TransConstants.SEX_M?"Laki-Laki":"Perempuan"%></td>
                 </tr>
                 <tr>
                    <td class="bold">Agama</td>          
                    <td>: <%=null!=ubn?ubn.getReligionVal():""%></td>
                 </tr>
                 <tr>
                    <td class="bold">Status Pernikahan</td>       
                    <td>: <%=null!=ubn?ubn.getMaritalStatusVal():""%></td>
                 </tr>
                 <tr>
                    <td class="bold">Status Hub Dalam Keluarga</td>       
                    <td>: <%=null!=ubn?ubn.getFamilyPosVal():""%></td>
                 </tr>
                 <tr>
                    <td class="bold">Kewarganegaraan</td>
                    <td>: <%=null!=ubn?ubn.getNationality():""%></td>
                 </tr>
                 </table>
                 <table style="float:left">
                 <tr>
                    <td class="bold" width="150px">Alamat</td>
                    <td>: <%=null!=ubn?ubn.getAddress():""%></td>
                 </tr>
                 <tr>
                    <td class="bold">Kota</td>
                    <td>: <%=null!=ubn?ubn.getCity():""%></td>
                 </tr>
                 <tr>
                    <td class="bold">Propinsi</td>
                    <td>: <%=null!=ubn?ubn.getRegion():""%></td>
                 </tr>
                 <tr>
                    <td class="bold">Kode Pos</td>
                    <td>: <%=null!=ubn?ubn.getPostalCode():""%></td>
                 </tr>
                 <tr>
                    <td class="bold">Kecamatan</td>
                    <td>: <%=null!=ubn?ubn.getKecamatan():""%></td>
                 </tr>
                 <tr>
                    <td class="bold">Kelurahan</td>
                    <td>: <%=null!=ubn?ubn.getKelurahan():""%></td>
                 </tr>
                 <tr>
                    <td class="bold">RT</td>
                    <td>: <%=null!=ubn?ubn.getRT():""%></td>
                 </tr>
                 <tr>
                    <td class="bold">RW</td>
                    <td>: <%=null!=ubn?ubn.getRW():""%></td>
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