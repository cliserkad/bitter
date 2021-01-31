:: init
TITLE Bitter Installer (.bat for Windows)
if not "%1"=="am_admin" (powershell start -verb runas '%0' am_admin & exit /b)
set install-dir=%HOMEPATH%\bitter
set jar-loc=%install-dir%\bitter.jar
set repo-loc=%install-dir%\repo

:: download bitter.jar
md %install-dir%
cd %install-dir%
powershell -Command "(New-Object Net.WebClient).DownloadFile('https://github.com/cliserkad/bitter/releases/latest/download/bitter.jar', '%jar-loc%')"

:: clone git repo
del %repo-loc% /F /Q
md %repo-loc%
cd %repo-loc%
git init .
git remote add origin https://github.com/cliserkad/bitter
git pull origin master

:: make shortcut and run
cd %install-dir%
mklink "%HOMEPATH%\Desktop\Bitter" %jar-loc%
powershell -Command "java -jar %jar-loc%"
