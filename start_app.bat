@echo off

REM Укажите путь к вашему Python-скрипту
SET SCRIPT_PATH="C:\Users\user\Desktop\Coding\TheDailyJournal\start_app.py"

REM Запуск скрипта. Если Python не в PATH, укажите полный путь:
REM "C:\Users\...\Python\python.exe" %SCRIPT_PATH%
python %SCRIPT_PATH%

REM Пауза не нужна, так как сам Python-скрипт блокируется (backend_process.wait()), 
REM пока пользователь не остановит выполнение (Ctrl+C).

REM Этот BAT-файл будет ждать завершения Python-скрипта, 
REM который, в свою очередь, ждет завершения backend.