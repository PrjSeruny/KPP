<%@page import="com.sync.master.beans.MasterResidentBean"%>
<%@page import=" java.io.*,
               com.sync.core.utils.Constants,
               com.sync.master.utils.MasterConstants,
               com.sync.core.beans.MessageBean,
               com.sync.core.utils.Utilities,
               com.sync.master.beans.MasterUserBean"
%>
<%
   String act = (String)request.getAttribute(MasterConstants.ACT);
   MasterResidentBean ubn = (MasterResidentBean)request.getAttribute(MasterConstants.MASTERRESIDENT_INFO);
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
 <form name="info" method="post" action="<%=Constants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>">
 <input type="hidden" name="<%=MasterConstants.W%>" value="<%=MasterConstants.MASTER_RESIDENT%>">
 <input type="hidden" name="<%=MasterConstants.ACT%>" value="<%=MasterConstants.ACT_UPDATE%>">
    <div class="form">
        <h2 class="title">Info Penduduk</h2>
        <fieldset>
            <div >
                <table border="0" style="float:left;margin-right:20px">
                 <tr>
                    <td class="bold" width="150px">NIK</td>
                    <td>
                        : <%=null!=ubn?ubn.getNIK():""%>
                       <input type="hidden" name="<%=MasterConstants.FORM_MASTERRESIDENT_NIK%>" value="<%=null!=ubn?ubn.getNIK():""%>">
                    </td>
                 </tr>
                 <tr>
                    <td class="bold">No.KK</td>
                    <td>: <%=null!=ubn?ubn.getKKNo():""%></td>
                 </tr>
                 <tr>
                    <td class="bold">Nama</td>
                    <td>: <%=null!=ubn?ubn.getName():""%></td>
                 </tr>
                 <tr>
                    <td class="bold">Tempat, Tgl Lahir</td>
                    <td>: <%=null!=ubn?ubn.getCity():""%>, <%=null!=ubn?Utilities.dateToString(ubn.getBirthDate(), MasterConstants.DATE_HTML_SHORT_PATTERN) :""%></td>
                 </tr>
                 <tr>
                    <td class="bold">Jenis Kelamin</td>
                    <td>: <%=null!=ubn&&ubn.getSex()==MasterConstants.SEX_M?"Laki-Laki":"Perempuan"%></td>
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
                    <td class="bold">Pekerjaan</td>
                    <td>: <%=null!=ubn?ubn.getWork():""%></td>
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
            <input type="submit" value="Ubah">
            <input type="submit" name="<%=MasterConstants.BTN_DONE %>" value="Selesai" class="negate">
        </div></fieldset>
    </div>
 </form>
</fieldset>