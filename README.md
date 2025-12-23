# F3Commands

[![Minecraft Version](https://img.shields.io/badge/Minecraft-1.21.5-green.svg)](https://www.minecraft.net/)
[![Fabric Loader](https://img.shields.io/badge/Fabric%20Loader-0.16.10%2B-blue.svg)](https://fabricmc.net/)
[![Fabric API](https://img.shields.io/badge/Fabric%20API-0.128.2%2B-blue.svg)](https://www.curseforge.com/minecraft/mc-mods/fabric-api)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

**Get debug information using simple client-side commands!**

F3Commands is a client-side Fabric mod that provides easy access to Minecraft's debug information through intuitive slash commands. No more memorizing complex F3 key combinations - just type what you need!

## ✨ Features

- 🎯 **70+ Client Commands** - Access all debug info via simple commands
- 📊 **Performance Tracking** - Monitor FPS, memory usage, and system resources
- 🌍 **World Information** - Get detailed info about your position, biome, dimension, and more
- ⚙️ **Debug Tools** - Check graphics settings, reload resources, and manage client state
- 🎨 **Color-Coded Output** - Easy-to-read, formatted command responses
- 📝 **Comprehensive Help** - Built-in help system with categorized commands
- 🚀 **Client-Side Only** - Works on any server without installation
- 🔧 **Mod Menu Integration** - Configure settings through Mod Menu (optional)

## 📦 Installation

### Requirements
- Minecraft 1.21.5
- Fabric Loader 0.16.10 or higher
- Fabric API 0.128.2 or higher
- Java 21 or higher

### Steps
1. Download and install [Fabric Loader](https://fabricmc.net/use/)
2. Download [Fabric API](https://www.curseforge.com/minecraft/mc-mods/fabric-api)
3. Download the latest F3Commands release
4. Place both `.jar` files in your `.minecraft/mods` folder
5. Launch Minecraft with the Fabric profile

### Optional Dependencies
- [Mod Menu](https://modrinth.com/mod/modmenu) - For in-game configuration
- [Cloth Config](https://modrinth.com/mod/cloth-config) - Bundled with the mod for settings UI

## 🎮 Commands

### Quick Start
Type `/f3help` in-game to see all available commands!

### Command Categories

#### 📍 Position & World Information (25 commands)
Get detailed information about your location and surroundings:

```
/mycoords          - Display XYZ coordinates
/myblockpos        - Display block position
/mychunkpos        - Display chunk coordinates
/myrotation        - Display yaw and pitch
/mydimension       - Current dimension
/mybiome           - Current biome
/myfacing          - Direction you're facing
/currenttime       - Time of day
/worldday          - Current world day
/moonphase         - Current moon phase
/myhealth          - Health status
/myhunger          - Hunger level
/mysaturation      - Saturation level
/myarmor           - Armor value
/myair             - Oxygen level
/myxplevel         - Experience level
/myxpbar           - Experience progress
/amionground       - Check if on ground
/myvelocity        - Movement velocity
/myspeed           - Movement speed
/myhorizontalspeed - Horizontal speed only
/lightlevel        - Total light level
/skylightlevel     - Sky light level
/blocklightlevel   - Block light level
/currentweather    - Weather status
```

#### 🔧 Debug & Settings (25 commands)
Check and manage game settings:

```
/advtooltips       - Check tooltip status
/switchtooltips    - Toggle advanced tooltips
/rechunks          - Reload chunks
/reresources       - Reload resource packs
/clearchat         - Clear chat history
/checkfullscreen   - Fullscreen status
/checkvsync        - VSync status
/checkfov          - Field of view
/checkrenderdist   - Render distance
/checksimuldist    - Simulation distance
/checkgraphics     - Graphics quality
/checkframelimit   - Max framerate
/checkguiscale     - GUI scale
/checkbrightness   - Brightness level
/checkentitydist   - Entity distance
/checkmastervol    - Master volume
/checkmusicvol     - Music volume
/checkmipmaplevel  - Mipmap level
/checkparticles    - Particle setting
/checksmoothlighting - Smooth lighting
/checkclouds       - Cloud rendering
/checkbiomeblend   - Biome blend radius
/checkautosave     - Autosave indicator
/viewlimitations   - F3 limitations notice
/windowinfo        - Window dimensions
```

#### ⚡ Performance Monitoring (20 commands)
Track game performance and system resources:

```
/currentfps        - Current FPS
/avgfps            - Average FPS
/maxfps            - Maximum FPS
/minfps            - Minimum FPS
/fpsreport         - Complete FPS report
/memused           - Memory used
/memmax            - Maximum memory
/memfree           - Free memory
/memusage          - Memory usage %
/memreport         - Complete memory report
/chunkupdates      - Chunk updates
/chunksloaded      - Loaded chunks
/chunkstats        - Chunk statistics
/entitycount       - Entity count
/particlecount     - Particle info
/javaversion       - Java version
/cpucores          - CPU core count
/osinfo            - OS information
/sysreport         - System report
/resetfpstracker   - Reset FPS tracker
/perfstatus        - Quick performance overview
```

#### 📚 Help System (4 commands)
```
/f3help            - Main help menu
/f3info            - Info commands list
/f3debug           - Debug commands list
/f3perf            - Performance commands list
```

## 🎨 Command Output

All commands use color-coded output for easy reading:
- **Gold (§6)** - Category labels
- **White (§f)** - Values and data
- **Yellow (§e)** - Command names
- **Green (§a)** - Subcategories
- **Red (§c)** - Warning values (e.g., high memory usage)

Example output:
```
§6Position: §fX: 123.45 Y: 64.00 Z: -789.12
§6Health: §f20.0 / 20.0
§6Memory Usage: §f1024 MB / 4096 MB (§c25%§f)
```

## 🔄 Version History

### v1.1.0+1.21.5 (Current)
- Complete command overhaul with 70+ commands
- Improved command naming to avoid vanilla conflicts
- Added comprehensive help system
- Enhanced color-coded output
- Expanded performance tracking
- Added system information commands
- Better memory reporting with percentages
- See [RELEASE_NOTES.md](RELEASE_NOTES.md) for full details

### v1.0.0
- Initial release
- Basic F3 command functionality

## 🛠️ Development

### Building from Source

```bash
git clone https://github.com/DraxonV1/F3Commands.git
cd F3Commands
./gradlew build
```

The compiled `.jar` file will be in `build/libs/`

### Project Structure
```
F3Commands/
├── src/main/java/com/draxon/f3commands/
│   ├── commands/
│   │   ├── debug/         - Debug commands
│   │   ├── help/          - Help system
│   │   ├── info/          - Info commands
│   │   ├── performance/   - Performance commands
│   │   └── CommandRegistrar.java
│   ├── config/            - Configuration
│   └── F3CommandsClient.java
└── src/main/resources/
    └── fabric.mod.json
```

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the Creative Commons CC0 1.0 Universal License - see the [LICENSE](LICENSE) file for details.

## 🐛 Bug Reports

Found a bug? Please open an issue on [GitHub](https://github.com/DraxonV1/F3Commands/issues) with:
- Minecraft version
- Fabric Loader version
- F3Commands version
- Steps to reproduce
- Expected vs actual behavior
- Screenshots (if applicable)

## 💬 Support

- **GitHub Issues**: [Report bugs or request features](https://github.com/DraxonV1/F3Commands/issues)
- **Wiki**: [Detailed documentation](https://f3commands.mc.draxon.asia)

## ⭐ Credits

- **Author**: DraxonV1
- **Built with**: [Fabric](https://fabricmc.net/)
- **Dependencies**: Fabric API, Cloth Config, Mod Menu (optional)

## 📊 Stats

- **Commands**: 70+
- **Categories**: 4 (Info, Debug, Performance, Help)
- **Lines of Code**: ~1,000+
- **Supported Versions**: Minecraft 1.21.5

---

**Made with ❤️ for the Minecraft Fabric community**

[Report a Bug](https://githuv.com/DraxonV1/F3Commands/issues) | [Request a Feature](https://github.com/DraxonV1/F3Commands/issues) | [View Wiki](https://f3commands.mc.draxon.asia)