<%@page import=" java.io.*,
               com.sync.core.utils.Constants,
               com.sync.master.utils.MasterConstants,
               com.sync.core.beans.MessageBean,
               com.sync.core.utils.Utilities,
               com.sync.master.beans.MasterUserBean"
%>
<fieldset class="wrapper">
  <div class="form">
    <h2 class="title">Form</h2>
    <fieldset>
      <div>
        <label>ID Lookup</label>
        <!-- 
        CARA MEMAKAI FUNSI LOOKUP
        1. menggunakan element a dengan class lookup
        2. menambah attribute valTarget dengan value selector id target (input / element), bisa lebih dari satu (dipisah menggunakan semicolon)
        3. beri id pada element yang akan dipakai untuk menampung value lookup sesuai dengan selector dari attribute valTarget
        4. attribute param digunakan untuk mengcustom lebar dan tinggi lookup window jika tidak dipakai maka default lebar dan tinggi adalah 400 x 300 pixel
        5. tambahkan attribute url dengan value link menuju halaman lookup, jangan lupan menambahkan parameter LOOKUP_SINGLE atau LOOKUP_MULTI dengan value 1
         -->
        <a href="javascript:void(0)" 
          class="lookup"
          valTarget="#userIDVal;#userNameVal"
          param="width=450;height=300"
          url="<%=Constants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>?<%=Constants.W%>=<%=MasterConstants.MASTERUSER%>&<%=MasterConstants.ACT%>=<%=MasterConstants.ACT_LOOKUP%>&<%=MasterConstants.LOOKUP_SINGLE%>=1">Lookup</a>
        <input type="text" id="userIDVal">
      </div>
      <div>
        <label>Input Option</label>
        <span id="userNameVal"></span>
      </div>
    </fieldset>
    <fieldset>
      <div>
        <label>Input Text</label>
        <input type="text">
      </div>
      <div>
        <label>Input Option</label>
        <select>
          <option>- Pilihan -</option>
        </select>
      </div>
    </fieldset>
    <fieldset>
      <div>
        <label>Input Textarea</label>
        <!-- 
          NB : untuk lookup multiple, attribute valTarget hanya boleh di isi 1 selector
         -->
        <a href="javascript:void(0)" class="lookup"
          valTarget="#userIDVals"
          url="<%=Constants.ROOT_PATH%><%=MasterConstants.SVT_MASTER_PATH%>?<%=Constants.W%>=<%=MasterConstants.MASTERUSER%>&<%=MasterConstants.ACT%>=<%=MasterConstants.ACT_LOOKUP%>&<%=MasterConstants.LOOKUP_MULTI%>=1">Lookup</a>
        <textarea id="userIDVals"></textarea>
      </div>
      <div>
        <label>Input Radio</label>
        <label class="input">
          <input type="radio" name="a"> Pilihan 1
          <input type="radio" name="a"> Pilihan 2
        </label>
      </div>
    </fieldset>
    <fieldset>
      <div>
        <label>Input Radio</label>
        <label class="input">
          <input type="checkbox" name="a"> Pilihan 1<br>
          <input type="checkbox" name="a"> Pilihan 2<br>
          <input type="checkbox" name="a"> Pilihan 3<br>
        </label>
      </div>
      <div>
        <label>Input File</label>
        <input type="file">
      </div>
    </fieldset>

    <fieldset>
      <div>
        <label>Input Image</label>
        <ul class="upload-img">
          <li>
            <a href="javascript:void(0)"></a>
            <input type="file">
          </li>
          <li>
            <a href="javascript:void(0)"></a>
            <input type="file">
          </li>
          <li>
            <a href="javascript:void(0)"></a>
            <input type="file">
          </li>
        </ul>
      </div>
    </fieldset>

    <fieldset>
      <div>
      <label>Button</label>
        <button>Simpan</button><button class="negate">Batal</button>
      </div>
      <div>
      <label>Link</label>
        <a href="#">www.domain.com</a>
      </div>
    </fieldset>
  </div>
</fieldset>

<fieldset class="wrapper">
  <div class="form" style="clear:left">
    <h2 class="title">Table List</h2>
    <div class="list-con">
      <table border="0" class="list-tb">
        <tr><th>Column 1</th><th>Column 2</th><th>Column 3</th><th>Column 4</th><th>Column 5</th><th>Column 6</th></tr>
        <tr><td>Content 1/1</td><td>Content 1/2</td><td>Content 1/3</td><td>Content 1/4</td><td>Content 1/5</td><td>Content 1/6</td></tr>
        <tr><td>Content 2/1</td><td>Content 2/2</td><td>Content 2/3</td><td>Content 2/4</td><td>Content 2/5</td><td>Content 2/6</td></tr>
      </table>
    </div>
  </div>
</fieldset>
