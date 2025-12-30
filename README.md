# **F3Commands** 🌟

**[Fabric Mod]** – Access Minecraft’s debug information with simple client-side commands!

F3Commands is a **client-side Fabric mod** that replaces complex F3 key combinations with intuitive slash commands. Get instant access to performance stats, world info, debug tools, and more—**without memorizing hotkeys!**

---

## ✨ **Features**

- **70+ Client Commands** – Access all debug info via simple commands.
- **Performance Tracking** – Monitor FPS, memory, and system resources.
- **World Information** – Get details about your position, biome, dimension, and more.
- **Debug Tools** – Check graphics settings, reload resources, and manage client state.
- **Color-Coded Output** – Easy-to-read, formatted responses.
- **Comprehensive Help** – Built-in help system with categorized commands.
- **Client-Side Only** – Works on any server without installation.
- **Mod Menu Integration** – Configure settings in-game (optional).

---

## 📦 **Installation**

### **Requirements**
- **Minecraft** (Fabric)
- **Fabric Loader** (latest stable)
- **Fabric API** (latest stable)
- **Java 17+**

### **Steps**
1. Install **[Fabric Loader](https://fabricmc.net/use/)**.
2. Download **[Fabric API](https://www.curseforge.com/minecraft/mc-mods/fabric-api)**.
3. Download the latest **F3Commands** release for your Minecraft version.
4. Place both `.jar` files in your `.minecraft/mods` folder.
5. Launch Minecraft with the Fabric profile.

### **Optional Dependencies**
- **[Mod Menu](https://modrinth.com/mod/modmenu)** – For in-game configuration.
- **[Cloth Config](https://modrinth.com/mod/cloth-config)** – Bundled for settings UI.

---

## 🎮 **Commands**

### **Quick Start**
Type `/f3help` in-game to see all available commands!

### **Command Categories**

#### **📍 Position & World Info**
Get details about your location and surroundings:
```
/mycoords, /myblockpos, /mychunkpos, /myrotation, /mydimension, /mybiome, /myfacing, /currenttime, /worldday, /moonphase, /myhealth, /myhunger, /mysaturation, /myarmor, /myair, /myxplevel, /myxpbar, /amionground, /myvelocity, /myspeed, /myhorizontalspeed, /lightlevel, /skylightlevel, /blocklightlevel, /currentweather
```

#### **🔧 Debug & Settings**
Check and manage game settings:
```
/advtooltips, /switchtooltips, /rechunks, /reresources, /clearchat, /checkfullscreen, /checkvsync, /checkfov, /checkrenderdist, /checksimuldist, /checkgraphics, /checkframelimit, /checkguiscale, /checkbrightness, /checkentitydist, /checkmastervol, /checkmusicvol, /checkmipmaplevel, /checkparticles, /checksmoothlighting, /checkclouds, /checkbiomeblend, /checkautosave, /viewlimitations, /windowinfo
```

#### **⚡ Performance Monitoring**
Track game performance and system resources:
```
/currentfps, /avgfps, /maxfps, /minfps, /fpsreport, /memused, /memmax, /memfree, /memusage, /memreport, /chunkupdates, /chunksloaded, /chunkstats, /entitycount, /particlecount, /javaversion, /cpucores, /osinfo, /sysreport, /resetfpstracker, /perfstatus
```

#### **📚 Help System**
```
/f3help, /f3info, /f3debug, /f3perf
```

---

## 🎨 **Command Output**
All commands use **color-coded output** for clarity:
- **Gold (§6)** – Category labels
- **White (§f)** – Values and data
- **Yellow (§e)** – Command names
- **Green (§a)** – Subcategories
- **Red (§c)** – Warnings (e.g., high memory usage)

**Example:**
```
§6Position: §fX: 123.45 Y: 64.00 Z: -789.12
§6Health: §f20.0 / 20.0
§6Memory Usage: §f1024 MB / 4096 MB (§c25%§f)
```

---

## 🛠️ **Development**

### **Building from Source**
```bash
git clone https://github.com/DraxonV1/F3Commands.git
cd F3Commands
./gradlew build
```
The compiled `.jar` will be in `build/libs/`.

### **Project Structure**
```
F3Commands/
├── src/main/java/com/draxon/f3commands/
│   ├── commands/
│   │   ├── debug/
│   │   ├── help/
│   │   ├── info/
│   │   ├── performance/
│   │   └── CommandRegistrar.java
│   ├── config/
│   └── F3CommandsClient.java
└── src/main/resources/
    └── fabric.mod.json
```

---

## 🤝 **Contributing**
Contributions are welcome! Submit a **Pull Request** or open an **Issue** on [GitHub](https://github.com/DraxonV1/F3Commands).

---

## 📝 **License**
**MIT License** – See [LICENSE](LICENSE).

---

## 🐛 **Bug Reports**
Found a bug? Report it on **[GitHub Issues](https://github.com/DraxonV1/F3Commands/issues)** with:
- Minecraft version
- Fabric Loader version
- F3Commands version
- Steps to reproduce
- Expected vs. actual behavior

---

## 💬 **Support**
- **[GitHub Issues](https://github.com/DraxonV1/F3Commands/issues)** – Bug reports & feature requests.
- **[Wiki](https://f3commands.mc.draxon.asia)** – Detailed documentation.

---

## ⭐ **Credits**
- **Author**: DraxonV1
- **Built with**: [Fabric](https://fabricmc.net/)
- **Dependencies**: Fabric API, Cloth Config, Mod Menu (optional)

---

**Made with ❤️ for the Minecraft Fabric community**

🔗 **[Modrinth](https://modrinth.com/mod/f3commands)** | **[GitHub](https://github.com/DraxonV1/F3Commands)** | **[Wiki](https://f3commands.mc.draxon.asia)**
