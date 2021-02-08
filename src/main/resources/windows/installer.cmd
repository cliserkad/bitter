:: init
TITLE Bitter Installer (.cmd for Windows)
if not "%1"=="am_admin" (powershell start -verb runas '%0' am_admin & exit /b)
set install-dir=%HOMEPATH%\bitter
set jar-loc=%install-dir%\bitter.jar
set repo-loc=%install-dir%\bitter

:: download bitter.jar
md %install-dir%
cd %install-dir%
curl -L https://github.com/cliserkad/bitter/releases/latest/download/bitter.jar --output %jar-loc%
curl -L https://github.com/cliserkad/bitter/releases/latest/download/bitter.cmd --output %install-dir%\bitter.cmd

:: clone git repo
del %repo-loc% /F /Q
git clone https://github.com/cliserkad/bitter

:: add to start menu
mklink "%AppData%\Microsoft\Windows\Start Menu\Programs" %jar-loc%

:: add to desktop
cd %install-dir%
mklink "%HOMEPATH%\Desktop\Bitter" %jar-loc%

:: run
start javaw -jar %jar-loc%

:: display output
echo "You may now close this window, or inspect the output."
pause
