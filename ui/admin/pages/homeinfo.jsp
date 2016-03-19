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
   
   String style = "";
   
   HttpSession ses = request.getSession(true);
   MasterUserBean usbn = (MasterUserBean)ses.getAttribute(MasterConstants.MASTERUSER);
   
   if(null==usbn){
     style = "background: linear-gradient(to bottom right, #C5C5C5 0%, #F9F9F9 100%);"+
         "position: absolute;"+
         "top: 0px;"+
         "left: 0;"+
         "width: 100%;"+
         "height: 93%;"+
         "overflow: hidden;"+
         "margin: 0px;"+
         "padding-top: 3%;";
   }
%>
<fieldset class="wrapper" style="<%=style%>">
    <div class="form" style="margin: auto;display: table;">
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
                    <td class="bold">Status Hub Dalam Keluarga</td>       
                    <td>: <%=null!=ubn?ubn.getFamilyPosVal():""%></td>
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
        <fieldset>
	        <div>
	        <input type="button" value="Kembali" onclick="javascript:window.history.back();">
	        </div>
        </fieldset>
    </div>
</fieldset>