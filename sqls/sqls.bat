drop table if exists UserLogin;
create table UserLogin
(
  ID          VARCHAR(50) NOT NULL,
  Password    VARCHAR(50) NOT NULL,
  Name        VARCHAR(50),
  CreateDate  VARCHAR(20) NOT NULL,
  CreateUser  VARCHAR(50) NOT NULL,
  EntryDate   VARCHAR(20),
  EntryUser   VARCHAR(50),
  VoidDate    VARCHAR(20),
  VoidUser    VARCHAR(50),
  primary key(ID)
)Engine=InnoDB;

insert into UserLogin values
('admin',sha('admin'), 'Administrator', '2016-01-01 17:00:00','admin', null, null, null, null);

drop table if exists MasterRegion;
create table MasterRegion
(
  RegionID     VARCHAR(100) NOT NULL,
  RegionName   VARCHAR(100) NOT NULL,
  StateProv    VARCHAR(100) NOT NULL,        
  Note         TEXT,
  CreateDate   VARCHAR(20) NOT NULL,
  CreateUser   VARCHAR(50) NOT NULL,
  EntryDate    VARCHAR(20),
  EntryUser    VARCHAR(50),
  VoidDate     VARCHAR(20),
  VoidUser     VARCHAR(50),
  PRIMARY KEY(RegionID)
)Engine=InnoDB;

drop table if exists MasterRegionKecamatan;
create table MasterRegionKecamatan
(
  RegionID         VARCHAR(100) NOT NULL,
  KecamatanID      VARCHAR(100) NOT NULL,
  Name             VARCHAR(100) NOT NULL,
  Note             TEXT,
  PRIMARY KEY(RegionID,KecamatanID)
)Engine=InnoDB;

drop table if exists MasterRegionKelurahan;
create table MasterRegionKelurahan
(
   RegionID           VARCHAR(100) NOT NULL,
   KecamatanID        VARCHAR(100) NOT NULL,
   KelurahanID        VARCHAR(100) NOT NULL,
   Name               VARCHAR(100) NOT NULL,
   Note               TEXT,
   PRIMARY KEY(RegionID, KecamatanID, KelurahanID)
)Engine=InnoDB;

insert into MasterRegion values                                         
(   'SBY',  'SURABAYA', 'JATIM',    '', '2016-01-01 00:00:00',  'root', null,    null,  null,   null    ),
(   'PRB',  'PROBOLINGGO',  'JATIM',    '', '2016-01-01 00:00:00',  'root', null,    null,  null,   null    ),
(   'PAS',  'PASURUAN', 'JATIM',    '', '2016-01-01 00:00:00',  'root', null,    null,  null,   null    ),
(   'MOJO', 'MOJOKERTO',    'JATIM',    '', '2016-01-01 00:00:00',  'root', null,    null,  null,   null    ),
(   'MLG',  'MALANG',   'JATIM',    '', '2016-01-01 00:00:00',  'root', null,    null,  null,   null    ),
(   'MDN',  'MADIUN',   'JATIM',    '', '2016-01-01 00:00:00',  'root', null,    null,  null,   null    ),
(   'KDR',  'KEDIRI',   'JATIM',    '', '2016-01-01 00:00:00',  'root', null,    null,  null,   null    ),
(   'BLTR', 'BLITAR',   'JATIM',    '', '2016-01-01 00:00:00',  'root', null,    null,  null,   null    ),
(   'BATU', 'BATU', 'JATIM',    '', '2016-01-01 00:00:00',  'root', null,    null,  null,   null    ),
(   'K.TLG',    'KAB.TULUNGAGUNG',  'JATIM',    '', '2016-01-01 00:00:00',  'root', null,    null,  null,   null    ),
(   'K.TBN',    'KAB.TUBAN',    'JATIM',    '', '2016-01-01 00:00:00',  'root', null,    null,  null,   null    ),
(   'K.TRENG',  'KAB.TRENGGALEK',   'JATIM',    '', '2016-01-01 00:00:00',  'root', null,    null,  null,   null    ),
(   'K.SMENEP', 'KAB.SUMENEP',  'JATIM',    '', '2016-01-01 00:00:00',  'root', null,    null,  null,   null    ),
(   'K.SITU',   'KAB.SITUBONDO',    'JATIM',    '', '2016-01-01 00:00:00',  'root', null,    null,  null,   null    ),
(   'K.SDA',    'KAB.SIDOARJO', 'JATIM',    '', '2016-01-01 00:00:00',  'root', null,    null,  null,   null    ),
(   'K.SMPNG',  'KAB.SAMPANG',  'JATIM',    '', '2016-01-01 00:00:00',  'root', null,    null,  null,   null    ),
(   'K.PRB',    'KAB.PROBOLINGGO',  'JATIM',    '', '2016-01-01 00:00:00',  'root', null,    null,  null,   null    ),
(   'K.PAS',    'KAB.PASURUAN', 'JATIM',    '', '2016-01-01 00:00:00',  'root', null,    null,  null,   null    ),
(   'K.PMKSAN', 'KAB.PAMEKASAN',    'JATIM',    '', '2016-01-01 00:00:00',  'root', null,    null,  null,   null    ),
(   'K.PACI',   'KAB.PACITAN',  'JATIM',    '', '2016-01-01 00:00:00',  'root', null,    null,  null,   null    ),
(   'K.NGAWI',  'KAB.NGAWI',    'JATIM',    '', '2016-01-01 00:00:00',  'root', null,    null,  null,   null    ),
(   'K.NGANJUK',    'KAB.NGANJUK',  'JATIM',    '', '2016-01-01 00:00:00',  'root', null,    null,  null,   null    ),
(   'K.MOJO',   'KAB.MOJOKERTO',    'JATIM',    '', '2016-01-01 00:00:00',  'root', null,    null,  null,   null    ),
(   'K.MLG',    'KAB.MALANG',   'JATIM',    '', '2016-01-01 00:00:00',  'root', null,    null,  null,   null    ),
(   'K.MGTN',   'KAB.MAGETAN',  'JATIM',    '', '2016-01-01 00:00:00',  'root', null,    null,  null,   null    ),
(   'K.MDN',    'KAB.MADIUN',   'JATIM',    '', '2016-01-01 00:00:00',  'root', null,    null,  null,   null    ),
(   'K.LMJG',   'KAB.LUMAJANG', 'JATIM',    '', '2016-01-01 00:00:00',  'root', null,    null,  null,   null    ),
(   'K.LA', 'KAB.LAMONGAN', 'JATIM',    '', '2016-01-01 00:00:00',  'root', null,    null,  null,   null    ),
(   'K.KDR',    'KAB.KEDIRI',   'JATIM',    '', '2016-01-01 00:00:00',  'root', null,    null,  null,   null    ),
(   'K.JBG',    'KAB.JOMBANG',  'JATIM',    '', '2016-01-01 00:00:00',  'root', null,    null,  null,   null    ),
(   'K.JBR',    'KAB.JEMBER',   'JATIM',    '', '2016-01-01 00:00:00',  'root', null,    null,  null,   null    ),
(   'K.GSK',    'KAB.GRESIK',   'JATIM',    '', '2016-01-01 00:00:00',  'root', null,    null,  null,   null    ),
(   'K.BONDO',  'KAB.BONDOWOSO',    'JATIM',    '', '2016-01-01 00:00:00',  'root', null,    null,  null,   null    ),
(   'K.BOJO',   'KAB.BOJONEGORO',   'JATIM',    '', '2016-01-01 00:00:00',  'root', null,    null,  null,   null    ),
(   'K.BLITAR', 'KAB.BLITAR',   'JATIM',    '', '2016-01-01 00:00:00',  'root', null,    null,  null,   null    ),
(   'K.BWANGI', 'KAB.BANYUWANGI',   'JATIM',    '', '2016-01-01 00:00:00',  'root', null,    null,  null,   null    ),
(   'K.BKLAN',  'KAB.BANGKALAN',    'JATIM',    '', '2016-01-01 00:00:00',  'root', null,    null,  null,   null    );


insert into MasterRegionKecamatan values                    
(   'SBY',    'KARANG_PILANG',    'KARANG PILANG',    NULL    ),
(   'SBY',    'JAMBANGAN',    'JAMBANGAN',    NULL    ),
(   'SBY',    'GAYUNGAN', 'GAYUNGAN', NULL    ),
(   'SBY',    'WONOCOLO', 'WONOCOLO', NULL    ),
(   'SBY',    'TENGGILIS_MEJOYO', 'TENGGILIS MEJOYO', NULL    ),
(   'SBY',    'GUNUNG_ANYAR', 'GUNUNG ANYAR', NULL    ),
(   'SBY',    'RUNGKUT',  'RUNGKUT',  NULL    ),
(   'SBY',    'SUKOLILO', 'SUKOLILO', NULL    ),
(   'SBY',    'MULYOREJO',    'MULYOREJO',    NULL    ),
(   'SBY',    'GUBENG',   'GUBENG',   NULL    ),
(   'SBY',    'WONOKROMO',    'WONOKROMO',    NULL    ),
(   'SBY',    'DUKUH_PAKIS',  'DUKUH PAKIS',  NULL    ),
(   'SBY',    'WIYUNG',   'WIYUNG',   NULL    ),
(   'SBY',    'LAKARSANTRI',  'LAKARSANTRI',  NULL    ),
(   'SBY',    'SAMBIKEREP',   'SAMBIKEREP',   NULL    ),
(   'SBY',    'TANDES',   'TANDES',   NULL    ),
(   'SBY',    'SUKO_MANUNGGAL',   'SUKO MANUNGGAL',   NULL    ),
(   'SBY',    'SAWAHAN',  'SAWAHAN',  NULL    ),
(   'SBY',    'TEGALSARI',    'TEGALSARI',    NULL    ),
(   'SBY',    'GENTENG',  'GENTENG',  NULL    ),
(   'SBY',    'TAMBAKSARI',   'TAMBAKSARI',   NULL    ),
(   'SBY',    'KENJERAN', 'KENJERAN', NULL    ),
(   'SBY',    'BULAK',    'BULAK',    NULL    ),
(   'SBY',    'SIMOKERTO',    'SIMOKERTO',    NULL    ),
(   'SBY',    'SEMAMPIR', 'SEMAMPIR', NULL    ),
(   'SBY',    'PABEAN_CANTIKAN',  'PABEAN CANTIKAN',  NULL    ),
(   'SBY',    'BUBUTAN',  'BUBUTAN',  NULL    ),
(   'SBY',    'KREMBANGAN',   'KREMBANGAN',   NULL    ),
(   'SBY',    'ASEMROWO', 'ASEMROWO', NULL    ),
(   'SBY',    'BENOWO',   'BENOWO',   NULL    ),
(   'SBY',    'PAKAL',    'PAKAL',    NULL    );

insert into  MasterRegionKelurahan values                       
(   'SBY',    'KARANG_PILANG',    'WARUGUNUNG',   'WARUGUNUNG',   NULL    ),
(   'SBY',    'KARANG_PILANG',    'KARANG_PILANG',    'KARANG PILANG',    NULL    ),
(   'SBY',    'KARANG_PILANG',    'KEBRAON',  'KEBRAON',  NULL    ),
(   'SBY',    'KARANG_PILANG',    'KEDURUS',  'KEDURUS',  NULL    ),
(   'SBY',    'JAMBANGAN',    'PAGESANGAN',   'PAGESANGAN',   NULL    ),
(   'SBY',    'JAMBANGAN',    'KEBONSARI',    'KEBONSARI',    NULL    ),
(   'SBY',    'JAMBANGAN',    'JAMBANGAN',    'JAMBANGAN',    NULL    ),
(   'SBY',    'JAMBANGAN',    'KARAH',    'KARAH',    NULL    ),
(   'SBY',    'GAYUNGAN', 'DUKUH_MENANGGAL',  'DUKUH MENANGGAL',  NULL    ),
(   'SBY',    'GAYUNGAN', 'MENANGGAL',    'MENANGGAL',    NULL    ),
(   'SBY',    'GAYUNGAN', 'GAYUNGAN', 'GAYUNGAN', NULL    ),
(   'SBY',    'GAYUNGAN', 'KETINTANG',    'KETINTANG',    NULL    ),
(   'SBY',    'WONOCOLO', 'SIWALANKERTO', 'SIWALANKERTO', NULL    ),
(   'SBY',    'WONOCOLO', 'JEMUR_WONOSARI',   'JEMUR WONOSARI',   NULL    ),
(   'SBY',    'WONOCOLO', 'MARGOREJO',    'MARGOREJO',    NULL    ),
(   'SBY',    'WONOCOLO', 'BENDUL_MERISI',    'BENDUL MERISI',    NULL    ),
(   'SBY',    'WONOCOLO', 'SIDOSERMO',    'SIDOSERMO',    NULL    ),
(   'SBY',    'TENGGILIS_MEJOYO', 'KUTISARI', 'KUTISARI', NULL    ),
(   'SBY',    'TENGGILIS_MEJOYO', 'KENDANGSARI',  'KENDANGSARI',  NULL    ),
(   'SBY',    'TENGGILIS_MEJOYO', 'TENGGILIS_MEJOYO', 'TENGGILIS MEJOYO', NULL    ),
(   'SBY',    'TENGGILIS_MEJOYO', 'PANJANG_JIWO', 'PANJANG JIWO', NULL    ),
(   'SBY',    'GUNUNG_ANYAR', 'RUNGKUT_MENANGGAL',    'RUNGKUT MENANGGAL',    NULL    ),
(   'SBY',    'GUNUNG_ANYAR', 'RUNGKUT_TENGAH',   'RUNGKUT TENGAH',   NULL    ),
(   'SBY',    'GUNUNG_ANYAR', 'GUNUNG_ANYAR', 'GUNUNG ANYAR', NULL    ),
(   'SBY',    'GUNUNG_ANYAR', 'GUNUNG_ANYAR_TAMBAK',  'GUNUNG ANYAR TAMBAK',  NULL    ),
(   'SBY',    'RUNGKUT',  'RUNGKUT_KIDUL',    'RUNGKUT KIDUL',    NULL    ),
(   'SBY',    'RUNGKUT',  'MEDOKAN_AYU',  'MEDOKAN AYU',  NULL    ),
(   'SBY',    'RUNGKUT',  'WONOREJO', 'WONOREJO', NULL    ),
(   'SBY',    'RUNGKUT',  'PENJARINGAN_SARI', 'PENJARINGAN SARI', NULL    ),
(   'SBY',    'RUNGKUT',  'KEDUNG_BARUK', 'KEDUNG BARUK', NULL    ),
(   'SBY',    'RUNGKUT',  'KALI_RUNGKUT', 'KALI RUNGKUT', NULL    ),
(   'SBY',    'SUKOLILO', 'NGIDEN_JANGKUNGAN',    'NGIDEN JANGKUNGAN',    NULL    ),
(   'SBY',    'SUKOLILO', 'SEMOLOWARU',   'SEMOLOWARU',   NULL    ),
(   'SBY',    'SUKOLILO', 'MEDOKAN_SEMAMPIR', 'MEDOKAN SEMAMPIR', NULL    ),
(   'SBY',    'SUKOLILO', 'KEPUTIH',  'KEPUTIH',  NULL    ),
(   'SBY',    'SUKOLILO', 'GEBANG_PUTIH', 'GEBANG PUTIH', NULL    ),
(   'SBY',    'SUKOLILO', 'KLAMPIS_NGASEM',   'KLAMPIS NGASEM',   NULL    ),
(   'SBY',    'SUKOLILO', 'MENUR_PUMPUNGAN',  'MENUR PUMPUNGAN',  NULL    ),
(   'SBY',    'MULYOREJO',    'MANYAR_SABRANGAN', 'MANYAR SABRANGAN', NULL    ),
(   'SBY',    'MULYOREJO',    'MULYOREJO',    'MULYOREJO',    NULL    ),
(   'SBY',    'MULYOREJO',    'KEJAWEN_PUTIH_TAMBAK', 'KEJAWEN PUTIH TAMBAK', NULL    ),
(   'SBY',    'MULYOREJO',    'KALISARI', 'KALISARI', NULL    ),
(   'SBY',    'MULYOREJO',    'DUKUH_SUTOREJO',   'DUKUH SUTOREJO',   NULL    ),
(   'SBY',    'MULYOREJO',    'KALIJUDAN',    'KALIJUDAN',    NULL    ),
(   'SBY',    'GUBENG',   'BARATAJAYA',   'BARATAJAYA',   NULL    ),
(   'SBY',    'GUBENG',   'PUCANG_SEWU',  'PUCANG SEWU',  NULL    ),
(   'SBY',    'GUBENG',   'KERTAJAYA',    'KERTAJAYA',    NULL    ),
(   'SBY',    'GUBENG',   'GUBENG',   'GUBENG',   NULL    ),
(   'SBY',    'GUBENG',   'AIRLANGGA',    'AIRLANGGA',    NULL    ),
(   'SBY',    'GUBENG',   'MOJO', 'MOJO', NULL    ),
(   'SBY',    'WONOKROMO',    'SAWUNGGALING', 'SAWUNGGALING', NULL    ),
(   'SBY',    'WONOKROMO',    'WONOKROMO',    'WONOKROMO',    NULL    ),
(   'SBY',    'WONOKROMO',    'JAGIR',    'JAGIR',    NULL    ),
(   'SBY',    'WONOKROMO',    'NGAGELREJO',   'NGAGELREJO',   NULL    ),
(   'SBY',    'WONOKROMO',    'NGAGEL',   'NGAGEL',   NULL    ),
(   'SBY',    'WONOKROMO',    'DARMO',    'DARMO',    NULL    ),
(   'SBY',    'DUKUH_PAKIS',  'GUNUNGSARI',   'GUNUNGSARI',   NULL    ),
(   'SBY',    'DUKUH_PAKIS',  'DUKUH_PAKIS',  'DUKUH PAKIS',  NULL    ),
(   'SBY',    'DUKUH_PAKIS',  'PRADAHKALI_KENDAL',    'PRADAHKALI KENDAL',    NULL    ),
(   'SBY',    'DUKUH_PAKIS',  'DUKUH_KUPANG', 'DUKUH KUPANG', NULL    ),
(   'SBY',    'WIYUNG',   'BALAS_KLUMPRIK',   'BALAS KLUMPRIK',   NULL    ),
(   'SBY',    'WIYUNG',   'BABATAN',  'BABATAN',  NULL    ),
(   'SBY',    'WIYUNG',   'WIYUNG',   'WIYUNG',   NULL    ),
(   'SBY',    'WIYUNG',   'JAJAR_TUNGGAL',    'JAJAR TUNGGAL',    NULL    ),
(   'SBY',    'LAKARSANTRI',  'BANGKINGAN',   'BANGKINGAN',   NULL    ),
(   'SBY',    'LAKARSANTRI',  'SUMUR_WELUT',  'SUMUR WELUT',  NULL    ),
(   'SBY',    'LAKARSANTRI',  'LIDAH_WETAN',  'LIDAH WETAN',  NULL    ),
(   'SBY',    'LAKARSANTRI',  'LIDAH_KULON',  'LIDAH KULON',  NULL    ),
(   'SBY',    'LAKARSANTRI',  'JERUK',    'JERUK',    NULL    ),
(   'SBY',    'LAKARSANTRI',  'LAKARSANTRI',  'LAKARSANTRI',  NULL    ),
(   'SBY',    'SAMBIKEREP',   'MADE', 'MADE', NULL    ),
(   'SBY',    'SAMBIKEREP',   'BRINGIN',  'BRINGIN',  NULL    ),
(   'SBY',    'SAMBIKEREP',   'SAMBIKEREP',   'SAMBIKEREP',   NULL    ),
(   'SBY',    'SAMBIKEREP',   'LONTAR',   'LONTAR',   NULL    ),
(   'SBY',    'TANDES',   'KARANGPOH',    'KARANGPOH',    NULL    ),
(   'SBY',    'TANDES',   'BALONGSARI',   'BALONGSARI',   NULL    ),
(   'SBY',    'TANDES',   'MANUKAN_WETAN',    'MANUKAN WETAN',    NULL    ),
(   'SBY',    'TANDES',   'MANUKAN_KULON',    'MANUKAN KULON',    NULL    ),
(   'SBY',    'TANDES',   'BANJAR_SUGIHAN',   'BANJAR SUGIHAN',   NULL    ),
(   'SBY',    'TANDES',   'TANDES',   'TANDES',   NULL    ),
(   'SBY',    'SUKO_MANUNGGAL',   'PUTAT_GEDE',   'PUTAT GEDE',   NULL    ),
(   'SBY',    'SUKO_MANUNGGAL',   'SONO_KWIJENAN',    'SONO KWIJENAN',    NULL    ),
(   'SBY',    'SUKO_MANUNGGAL',   'SIMOMULYO',    'SIMOMULYO',    NULL    ),
(   'SBY',    'SUKO_MANUNGGAL',   'SUKO_MANUNGGAL',   'SUKO MANUNGGAL',   NULL    ),
(   'SBY',    'SUKO_MANUNGGAL',   'TANJUNGSARI',  'TANJUNGSARI',  NULL    ),
(   'SBY',    'SUKO_MANUNGGAL',   'SIMOMULYO_BARU',   'SIMOMULYO BARU',   NULL    ),
(   'SBY',    'SAWAHAN',  'PAKIS',    'PAKIS',    NULL    ),
(   'SBY',    'SAWAHAN',  'PUTAT_JAYA',   'PUTAT JAYA',   NULL    ),
(   'SBY',    'SAWAHAN',  'BANYU_URIP',   'BANYU URIP',   NULL    ),
(   'SBY',    'SAWAHAN',  'KUPANG_KRAJAN',    'KUPANG KRAJAN',    NULL    ),
(   'SBY',    'SAWAHAN',  'PETEMON',  'PETEMON',  NULL    ),
(   'SBY',    'SAWAHAN',  'SAWAHAN',  'SAWAHAN',  NULL    ),
(   'SBY',    'TEGALSARI',    'KEPUTRAN', 'KEPUTRAN', NULL    ),
(   'SBY',    'TEGALSARI',    'DR.SUTOMO',    'DR.SUTOMO',    NULL    ),
(   'SBY',    'TEGALSARI',    'TEGALSARI',    'TEGALSARI',    NULL    ),
(   'SBY',    'TEGALSARI',    'WONOREJO', 'WONOREJO', NULL    ),
(   'SBY',    'TEGALSARI',    'KEDUNGDORO',   'KEDUNGDORO',   NULL    ),
(   'SBY',    'GENTENG',  'EMBONG_KALIASIN',  'EMBONG KALIASIN',  NULL    ),
(   'SBY',    'GENTENG',  'KETABANG', 'KETABANG', NULL    ),
(   'SBY',    'GENTENG',  'GENTENG',  'GENTENG',  NULL    ),
(   'SBY',    'GENTENG',  'PENELEH',  'PENELEH',  NULL    ),
(   'SBY',    'GENTENG',  'KAPASARI', 'KAPASARI', NULL    ),
(   'SBY',    'TAMBAKSARI',   'PACAR_KELING', 'PACAR KELING', NULL    ),
(   'SBY',    'TAMBAKSARI',   'PACAR_KEMBANG',    'PACAR KEMBANG',    NULL    ),
(   'SBY',    'TAMBAKSARI',   'PLOSO',    'PLOSO',    NULL    ),
(   'SBY',    'TAMBAKSARI',   'TAMBAKSARI',   'TAMBAKSARI',   NULL    ),
(   'SBY',    'TAMBAKSARI',   'RANGKAH',  'RANGKAH',  NULL    ),
(   'SBY',    'TAMBAKSARI',   'GADING',   'GADING',   NULL    ),
(   'SBY',    'TAMBAKSARI',   'KAPASMADYA_BARU',  'KAPASMADYA BARU',  NULL    ),
(   'SBY',    'TAMBAKSARI',   'DUKUH_SETRO',  'DUKUH SETRO',  NULL    ),
(   'SBY',    'KENJERAN', 'TANAH_KALI_KEDINDING', 'TANAH KALI KEDINDING', NULL    ),
(   'SBY',    'KENJERAN', 'SIDOTOPO_WETAN',   'SIDOTOPO WETAN',   NULL    ),
(   'SBY',    'KENJERAN', 'BULAK_BANTENG',    'BULAK BANTENG',    NULL    ),
(   'SBY',    'KENJERAN', 'TAMBAK_WEDI',  'TAMBAK WEDI',  NULL    ),
(   'SBY',    'BULAK',    'KENJERAN', 'KENJERAN', NULL    ),
(   'SBY',    'BULAK',    'BULAK',    'BULAK',    NULL    ),
(   'SBY',    'BULAK',    'KEDUNG_COWEK', 'KEDUNG COWEK', NULL    ),
(   'SBY',    'BULAK',    'SUKOLILO_BARU',    'SUKOLILO BARU',    NULL    ),
(   'SBY',    'SIMOKERTO',    'KAPASAN',  'KAPASAN',  NULL    ),
(   'SBY',    'SIMOKERTO',    'TAMBAKREJO',   'TAMBAKREJO',   NULL    ),
(   'SBY',    'SIMOKERTO',    'SIMOKERTO',    'SIMOKERTO',    NULL    ),
(   'SBY',    'SIMOKERTO',    'SIDODADI', 'SIDODADI', NULL    ),
(   'SBY',    'SIMOKERTO',    'SIMOLAWANG',   'SIMOLAWANG',   NULL    ),
(   'SBY',    'SEMAMPIR', 'AMPEL',    'AMPEL',    NULL    ),
(   'SBY',    'SEMAMPIR', 'SIDOTOPO', 'SIDOTOPO', NULL    ),
(   'SBY',    'SEMAMPIR', 'PEGIRIAN', 'PEGIRIAN', NULL    ),
(   'SBY',    'SEMAMPIR', 'WONOKUSUMO',   'WONOKUSUMO',   NULL    ),
(   'SBY',    'SEMAMPIR', 'UJUNG',    'UJUNG',    NULL    ),
(   'SBY',    'PABEAN_CANTIKAN',  'BONGKARAN',    'BONGKARAN',    NULL    ),
(   'SBY',    'PABEAN_CANTIKAN',  'NYAMPLUNGAN',  'NYAMPLUNGAN',  NULL    ),
(   'SBY',    'PABEAN_CANTIKAN',  'KREMBANGAN_UTARA', 'KREMBANGAN UTARA', NULL    ),
(   'SBY',    'PABEAN_CANTIKAN',  'PERAK_TIMUR',  'PERAK TIMUR',  NULL    ),
(   'SBY',    'PABEAN_CANTIKAN',  'PERAK_UTARA',  'PERAK UTARA',  NULL    ),
(   'SBY',    'BUBUTAN',  'TEMBOK_DUKUH', 'TEMBOK DUKUH', NULL    ),
(   'SBY',    'BUBUTAN',  'BUBUTAN',  'BUBUTAN',  NULL    ),
(   'SBY',    'BUBUTAN',  'ALON-ALON_CONTONG',    'ALON-ALON CONTONG',    NULL    ),
(   'SBY',    'BUBUTAN',  'GUNDIH',   'GUNDIH',   NULL    ),
(   'SBY',    'BUBUTAN',  'JEPARA',   'JEPARA',   NULL    ),
(   'SBY',    'KREMBANGAN',   'DUPAK',    'DUPAK',    NULL    ),
(   'SBY',    'KREMBANGAN',   'MOROKREMBANGAN',   'MOROKREMBANGAN',   NULL    ),
(   'SBY',    'KREMBANGAN',   'PERAK_BARAT',  'PERAK BARAT',  NULL    ),
(   'SBY',    'KREMBANGAN',   'KEMAYORAN',    'KEMAYORAN',    NULL    ),
(   'SBY',    'KREMBANGAN',   'KREMBANGAN_SELATAN',   'KREMBANGAN SELATAN',   NULL    ),
(   'SBY',    'ASEMROWO', 'ASEMROWO', 'ASEMROWO', NULL    ),
(   'SBY',    'ASEMROWO', 'GENTING_KALIANAK', 'GENTING KALIANAK', NULL    ),
(   'SBY',    'ASEMROWO', 'TAMBAK_SARIOSO',   'TAMBAK SARIOSO',   NULL    ),
(   'SBY',    'BENOWO',   'SEMEMI',   'SEMEMI',   NULL    ),
(   'SBY',    'BENOWO',   'KANDANGAN',    'KANDANGAN',    NULL    ),
(   'SBY',    'BENOWO',   'TAMBAK_OSO_WILANGON',  'TAMBAK OSO WILANGON',  NULL    ),
(   'SBY',    'BENOWO',   'ROMOKALISARI', 'ROMOKALISARI', NULL    ),
(   'SBY',    'PAKAL',    'BABAT_JERAWAT',    'BABAT JERAWAT',    NULL    ),
(   'SBY',    'PAKAL',    'PAKAL',    'PAKAL',    NULL    ),
(   'SBY',    'PAKAL',    'BENOWO',   'BENOWO',   NULL    ),
(   'SBY',    'PAKAL',    'SUMBERREJO',   'SUMBERREJO',   NULL    );


drop table if exists MasterResident;
create table MasterResident  
(
   NIK            VARCHAR(100) NOT NULL,
   KKNo           VARCHAR(100) NOT NULL,
   Name           VARCHAR(100) NOT NULL,
   BirthCity      VARCHAR(100) NOT NULL,
   BirthDate      VARCHAR(20) NOT NULL,
   DeathDate      VARCHAR(20),
   Sex            INT,
   Religion       VARCHAR(20) NOT NULL,
   MaritalStatus  VARCHAR(100) NOT NULL,
   FamilyPos      VARCHAR(10),
   Work           VARCHAR(100),
   Nationality    VARCHAR(100) NOT NULL,  #Kewarganegaraan
   Address        VARCHAR(100) NOT NULL,
   City           VARCHAR(100) NOT NULL,  #Kota
   Region         VARCHAR(100) NOT NULL,  #Propinsi
   PostalCode     VARCHAR(20) NOT NULL,
   Kelurahan      VARCHAR(75) NOT NULL,
   Kecamatan      VARCHAR(75) NOT NULL,
   RT             VARCHAR(20) NOT NULL,
   RW             VARCHAR(20) NOT NULL,
   Note           TEXT,
   CreateDate     VARCHAR(20) NOT NULL,
   CreateUser     VARCHAR(50) NOT NULL,
   EntryDate      VARCHAR(20),
   EntryUser      VARCHAR(50),
   VoidDate       VARCHAR(20),
   VoidUser       VARCHAR(50),
   PRIMARY KEY(NIK)
)Engine=InnoDB;

DROP TABLE IF EXISTS MasterResidentHistory;
CREATE TABLE MasterResidentHistory
(
   NIK            VARCHAR(100) NOT NULL,
   StartDate      VARCHAR(50) NOT NULL,
   EndDate        VARCHAR(50),
   KKNo           VARCHAR(100) NOT NULL,
   Name           VARCHAR(100) NOT NULL,
   Sex            INT,
   Religion       VARCHAR(20) NOT NULL,
   MaritalStatus  VARCHAR(100) NOT NULL,
   FamilyPos      VARCHAR(10),
   Nationality    VARCHAR(100) NOT NULL,  #Kewarganegaraan
   Address        VARCHAR(100) NOT NULL,
   City           VARCHAR(100) NOT NULL,  #Kota
   Region         VARCHAR(100) NOT NULL,  #Propinsi
   PostalCode     VARCHAR(20) NOT NULL,
   Kelurahan      VARCHAR(75) NOT NULL,
   Kecamatan      VARCHAR(75) NOT NULL,
   RT             VARCHAR(20) NOT NULL,
   RW             VARCHAR(20) NOT NULL,
   EntryDate      VARCHAR(20) NOT NULL,
   EntryUser      VARCHAR(50) NOT NULL,
   PRIMARY KEY(NIK, StartDate)
)Engine=InnoDB;

#Mutasi KK
DROP TABLE IF EXISTS FamilyCardMutation;
CREATE TABLE FamilyCardMutation
(
   NIK                 VARCHAR(100) NOT NULL,
   Name                VARCHAR(100) NOT NULL,
   StartDate           VARCHAR(100) NOT NULL,
   OldKK               VARCHAR(100) NOT NULL,
   NewKK               VARCHAR(100) NOT NULL,
   Sex                 INT,
   Religion            VARCHAR(20) NOT NULL,
   MaritalStatus       VARCHAR(100) NOT NULL,
   FamilyPos           VARCHAR(10),
   StatusInFamily      VARCHAR(10),
   Nationality         VARCHAR(100) NOT NULL,  #Kewarganegaraan
   Address             VARCHAR(100) NOT NULL,
   City                VARCHAR(100) NOT NULL,  #Kota
   Region              VARCHAR(100) NOT NULL,  #Propinsi
   PostalCode          VARCHAR(20) NOT NULL,
   Kelurahan           VARCHAR(75) NOT NULL,
   Kecamatan           VARCHAR(75) NOT NULL,
   RT                  VARCHAR(20) NOT NULL,
   RW                  VARCHAR(20) NOT NULL,
   NOTE                TEXT,
   CreateDate          VARCHAR(20) NOT NULL,
   CreateUser          VARCHAR(50) NOT NULL,
   EntryDate           VARCHAR(20),
   EntryUser           VARCHAR(50),
   ProcessDate         VARCHAR(20),
   ProcessUser         VARCHAR(50),
   CancelProcessDate   VARCHAR(20),
   CancelProcessUser   VARCHAR(50),
   PRIMARY KEY(NIK,StartDate)
)Engine=InnoDB;

#Transaksi Surat Kematian
drop table if exists DeathLetter;
create table DeathLetter
(
  NIK                  VARCHAR(100) NOT NULL,
  Name                 VARCHAR(100) NOT NULL,
  DeathDate            VARCHAR(20) NOT NULL,
  CreateDate           VARCHAR(20) NOT NULL,
  CreateUser           VARCHAR(50) NOT NULL,
  EntryDate            VARCHAR(20),
  EntryUser            VARCHAR(50),
  ProcessDate          VARCHAR(20),
  ProcessUser          VARCHAR(50),
  CancelProcessDate    VARCHAR(20),
  CancelProcessUser    VARCHAR(50),
  Note                 TEXT,
  PRIMARY KEY(NIK)
)Engine=InnoDB;

#Transaksi Surat Kelahiran
drop table if exists BirthLetter;
create table BirthLetter
(
  NIK                  VARCHAR(100) NOT NULL,
  KKNo                 VARCHAR(100) NOT NULL,
  Name                 VARCHAR(100) NOT NULL,
  BirthDate            VARCHAR(20) NOT NULL,
  FatherNIK            VARCHAR(100) NOT NULL,
  FatherName           VARCHAR(100) NOT NULL,
  MotherNIK            VARCHAR(100) NOT NULL,
  MotherName           VARCHAR(100) NOT NULL,
  CreateDate           VARCHAR(20) NOT NULL,
  CreateUser           VARCHAR(50) NOT NULL,
  EntryDate            VARCHAR(20),
  EntryUser            VARCHAR(50),
  ProcessDate          VARCHAR(20),
  ProcessUser          VARCHAR(50),
  CancelProcessDate    VARCHAR(20),
  CancelProcessUser    VARCHAR(50),
  Note                 TEXT,
  PRIMARY KEY(NIK)
)Engine=InnoDB;

DROP TABLE IF EXISTS SlideSetting;
CREATE TABLE IF NOT EXISTS SlideSetting 
(
  ID            INT(1) NOT NULL,
  Path          VARCHAR(255) NOT NULL,
  Path_Thumb    VARCHAR(255) NOT NULL,
  PRIMARY KEY (ID)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS Gallery;
CREATE TABLE IF NOT EXISTS Gallery 
(
  ID                INT(4) NOT NULL AUTO_INCREMENT,
  Title             VARCHAR(100) DEFAULT NULL,
  Description       TEXT,
  Path              VARCHAR(255) NOT NULL,
  Path_Thumb        VARCHAR(255) NOT NULL,
  DateCreate        VARCHAR(50) NOT NULL,
  PRIMARY KEY (ID)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS News;
CREATE TABLE News
(
   ID               INT(4) NOT NULL AUTO_INCREMENT,
   Title            VARCHAR(100) DEFAULT NULL,
   Description      TEXT NOT NULL,
   Path             VARCHAR(255) NOT NULL,
   Path_Thumb       VARCHAR(255) NOT NULL,
   EntryDate        VARCHAR(50) NOT NULL,
   PRIMARY KEY (ID)
)ENGINE=InnoDB;




