[Setup]
AppName=Artcafe System
AppVersion=1.0
DefaultDirName={pf}\ArtcafeSystem
DefaultGroupName=Artcafe System
OutputBaseFilename=artcafe_installer
SetupIconFile=artcafe_icon.ico

[Files]
Source: "path\to\your\jar\file\artcafe_system.jar"; DestDir: "{app}"; Flags: ignoreversion
Source: "path\to\your\icon\artcafe_icon.ico"; DestDir: "{app}"; Flags: ignoreversion

[Icons]
Name: "{group}\Artcafe System"; Filename: "{app}\artcafe_system.jar"; WorkingDir: "{app}"
