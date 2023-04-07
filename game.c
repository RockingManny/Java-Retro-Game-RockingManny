// #include <windows.h>

// int main() {
//     STARTUPINFO si = { sizeof(si) };
//     PROCESS_INFORMATION pi;
//     TCHAR command[] = TEXT("java -cp bin com.skillrisers.streetfighter.gaming.GameScreen");

//     if (!CreateProcess(NULL, command, NULL, NULL, FALSE, 0, NULL, NULL, &si, &pi)) {
//         // handle error
//         return 1;
//     }

//     WaitForSingleObject(pi.hProcess, INFINITE);

//     CloseHandle(pi.hProcess);
//     CloseHandle(pi.hThread);

//     return 0;
// }


#include <stdlib.h>

#pragma comment(linker, "/SUBSYSTEM:windows /ENTRY:main")

int main() {
    system("java -cp bin com.skillrisers.streetfighter.gaming.GameScreen");
    return 0;
}