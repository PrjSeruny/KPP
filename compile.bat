
rmdir C:\Tech\Apache\Tomcat\webapps\simorg\ui /s /q
rmdir C:\Tech\Apache\Tomcat\webapps\simorg\WEB-INF\lib /s /q
mkdir C:\Tech\Apache\Tomcat\webapps\simorg\WEB-INF\lib
copy lib C:\Tech\Apache\Tomcat\webapps\simorg\WEB-INF\lib
mkdir C:\Tech\Apache\Tomcat\webapps\simorg\ui
xcopy ui\* C:\Tech\Apache\Tomcat\webapps\simorg\ui /e /i
