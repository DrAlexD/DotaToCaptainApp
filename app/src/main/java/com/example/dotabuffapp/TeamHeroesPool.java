package com.example.dotabuffapp;

enum TeamHeroesPool {
    Abaddon("3"),
    Alchemist("2"),
    AncientApparition("5"),
    AntiMage("1"),
    Axe("3"),
    Bane("5"),
    Batrider("3"),
    Beastmaster("3"),
    Bloodseeker("1|2"),
    BountyHunter("1|4"),
    Brewmaster("3"),
    Bristleback("1|2|3"),
    CentaurWarrunner("3"),
    ChaosKnight("1"),
    Clockwerk("4"),
    CrystalMaiden("5"),
    DarkSeer("3"),
    Dazzle("2|5"),
    DeathProphet("2"),
    Disruptor("5"),
    Doom("1|3"),
    DragonKnight("2|3"),
    DrowRanger("1"),
    Earthshaker("4"),
    EmberSpirit("1|2"),
    Enchantress("3"),
    Enigma("3"),
    FacelessVoid("1"),
    Grimstroke("4|5"),
    Gyrocopter("1"),
    Io("4"),
    Jakiro("5"),
    Juggernaut("1"),
    KeeperOfTheLight("4"),
    Kunkka("2"),
    LegionCommander("1|2"),
    Leshrac("1|2"),
    Lich("5"),
    Lifestealer("1"),
    Lina("2|4|5"),
    Lion("4|5"),
    LoneDruid("1|2"),
    Luna("1"),
    Lycan("1"),
    Magnus("3"),
    Mars("3"),
    Medusa("2"),
    Mirana("2"),
    MonkeyKing("1|2"),
    Morphling("1|2"),
    NagaSiren("1"),
    NaturesProphet("3"),
    Necrophos("1|2"),
    OgreMagi("5"),
    Omniknight("3"),
    Oracle("5"),
    OutworldDevourer("2"),
    Pangolier("3"),
    PhantomAssassin("1"),
    PhantomLancer("1"),
    Puck("3"),
    Pugna("2"),
    QueenOfPain("2"),
    Razor("1|2"),
    Rubick("4"),
    SandKing("3|4"),
    ShadowDemon("4|5"),
    ShadowFiend("2"),
    ShadowShaman("4|5"),
    Silencer("5"),
    SkywrathMage("4"),
    Slark("1"),
    Sniper("2"),
    Spectre("1"),
    SpiritBreaker("4"),
    StormSpirit("2"),
    Sven("1"),
    TemplarAssassin("2"),
    Terrorblade("1"),
    Tidehunter("3"),
    Timbersaw("1|2"),
    TrollWarlord("1"),
    Tusk("4"),
    Ursa("1"),
    VengefulSpirit("5"),
    Viper("2"),
    Warlock("5"),
    Weaver("1"),
    Windranger("2|4|5"),
    WinterWyvern("4|5"),
    WitchDoctor("5"),
    WraithKing("1"),
    Zeus("2");

    String pos;

    TeamHeroesPool(String pos) {
        this.pos = pos;
    }
}