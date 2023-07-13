# Smart Villagers Follow Emeralds

A simple Fabric mod that makes villagers follow players holding emerald-related items including 
Emeralds, Emerald Blocks, Emerald Ore, and Emerald Deepslate Ore.

### Doesn't this already exist?

This mod is indeed functionally similar to
[Villagers-Follow-Emeralds-Fabric](https://github.com/Hyperbean18/Villagers-Follow-Emeralds-Fabric),
but distinct in a few important ways.

Internally, the comparable Villagers-Follow-Emeralds-Fabric adds an AI goal to villagers to modify their behaviour, 
which creates a conflict with the brain tasks villagers make use of since 1.14, 
resulting in often inconsistent emerald following.
This mod instead makes use of a proper brain task to add following behaviour,
which is much more reliable and future-proof. 
This is also where the "Smart" in the name comes from.

Another difference is that this mod uses a tag to determine which items tempt villagers,
which means that it is possible for server owners and modpack creators 
to add custom items to this list if they so desire.