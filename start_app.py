import os
import subprocess
import time

# --- Пути и команды ---
backend_directory = r"C:\Users\user\Desktop\Coding\TheDailyJournal\Backend"
frontend_directory = r"C:\Users\user\Desktop\Coding\TheDailyJournal\Frontend\daily-journal"

# Команды для выполнения
# В Windows для открытия нового окна используем префикс 'start /wait' или 'cmd /c start'
# Здесь используем 'start' внутри команды, чтобы обеспечить открытие нового окна
# (хотя CREATE_NEW_CONSOLE это сделает, 'start' полезен для корректной обработки)
run_spring_boot = "cmd /c start \"Backend Server\" mvn clean package spring-boot:run"
run_react = "cmd /c start \"Frontend Dev\" npm run dev"

# --- Исполнение ---
try:
    # 1. Запуск Backend (Spring Boot) в новой консоли
    print(f"[{time.strftime('%H:%M:%S')}] 🚀 Запуск Backend (Spring Boot) в новом окне...")
    
    # Popen запускает команду и не ждет ее завершения
    backend_process = subprocess.Popen(
        run_spring_boot,
        cwd=backend_directory, # Указываем директорию напрямую
        shell=True,
        # Флаг CREATE_NEW_CONSOLE гарантирует, что будет создано новое консольное окно
        creationflags=subprocess.CREATE_NEW_CONSOLE 
    )
    print(f"Backend запущен с PID: {backend_process.pid}")

    # Даем немного времени Backend на инициализацию
    time.sleep(10) 
    print(f"[{time.strftime('%H:%M:%S')}] ⏳ Пауза завершена, приступаем к Frontend.")

    # 2. Запуск Frontend (React) в новой консоли
    print(f"[{time.strftime('%H:%M:%S')}] 🚀 Запуск Frontend (React) в новом окне...")
    
    frontend_process = subprocess.Popen(
        run_react,
        cwd=frontend_directory, # Указываем директорию напрямую
        shell=True,
        # Флаг CREATE_NEW_CONSOLE гарантирует, что будет создано новое консольное окно
        creationflags=subprocess.CREATE_NEW_CONSOLE
    )
    print(f"Frontend запущен с PID: {frontend_process.pid}")

    # 3. Ожидание завершения (основной скрипт завершится, но процессы в отдельных окнах будут работать)
    print("\n-------------------------------------------------------------------------")
    print("🔥 Оба сервиса запущены в ОТДЕЛЬНЫХ ОКНАХ. Основной скрипт завершен.")
    print("Чтобы остановить сервисы, просто закройте их соответствующие консольные окна.")
    print("-------------------------------------------------------------------------")
    
    # Поскольку процессы запущены в новых окнах (используя 'start' и CREATE_NEW_CONSOLE), 
    # вам не нужно блокировать основной скрипт через .wait().
    # Основной скрипт просто завершит свою работу.
    
except Exception as e:
    print(f"Произошла непредвиденная ошибка: {e}")
    
finally:
    # Здесь не нужно вызывать .terminate(), так как процессы запущены в отдельных
    # окнах и продолжат работать независимо от завершения этого скрипта.
    pass