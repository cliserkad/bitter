:: init
TITLE Bitter Installer (.bat for Windows)
if not "%1"=="am_admin" (powershell start -verb runas '%0' am_admin & exit /b)
set install-dir=%HOMEPATH%\bitter
set jar-loc=%install-dir%\bitter.jar
set repo-loc=%install-dir%\bitter

:: download bitter.jar
md %install-dir%
cd %install-dir%
powershell -Command "(New-Object Net.WebClient).DownloadFile('https://github.com/cliserkad/bitter/releases/latest/download/bitter.jar', '%jar-loc%')"

:: clone git repo
del %repo-loc% /F /Q
git clone https://github.com/cliserkad/bitter

:: add to start menu
mklink "%AppData%\Microsoft\Windows\Start Menu\Programs" %jar-loc%

:: add to desktop
cd %install-dir%
mklink "%HOMEPATH%\Desktop\Bitter" %jar-loc%

:: run
powershell -Command "javaw -jar %jar-loc%"
