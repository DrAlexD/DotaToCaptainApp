package com.example.dotabuffapp;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

class HeroesWithTiers extends AsyncTask<Void, Void, Void> implements Serializable {
    private transient Context context;
    private ArrayList<Hero> originalHeroesWithTiers;
    private ArrayList<Hero> currentHeroesWithTiers;
    private ArrayList<Hero> deletedHeroesWithTiers;

    HeroesWithTiers(Context context) {
        this.context = context;
        this.originalHeroesWithTiers = new ArrayList<>();
        this.currentHeroesWithTiers = new ArrayList<>();
        this.deletedHeroesWithTiers = new ArrayList<>();
    }

    ArrayList<Hero> getCurrentHeroesWithTiers() {
        return currentHeroesWithTiers;
    }

    ArrayList<Hero> getOriginalHeroesWithTiers() {
        return originalHeroesWithTiers;
    }

    void addHero(HeroesPool heroesPoolHero) {
        int i = 0;
        String heroName = heroesPoolHero.toHeroName();
        for (Hero hero : deletedHeroesWithTiers) {
            if (heroName.equals(hero.getName())) {
                currentHeroesWithTiers.add(deletedHeroesWithTiers.remove(i));
                Hero.sortHeroes(currentHeroesWithTiers, 0, currentHeroesWithTiers.size() - 1, false);
                break;
            }
            i++;
        }
    }

    void deleteHero(HeroesPool heroesPoolHero) {
        if (heroesPoolHero != null) {
            int i = 0;
            String heroName = heroesPoolHero.toHeroName();
            for (Hero hero : currentHeroesWithTiers) {
                if (heroName.equals(hero.getName())) {
                    deletedHeroesWithTiers.add(currentHeroesWithTiers.remove(i));
                    break;
                }
                i++;
            }
        }
    }

    @Override
    protected void onPostExecute(Void unused) {
        Toast.makeText(context, "Винрейты героев загружены", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected Void doInBackground(Void... unused) {
        try {
            Document heroesDoc = Jsoup.connect("https://ru.dotabuff.com/heroes/trends").get();

            Elements heroes = heroesDoc.getElementsByTag("tr");

            for (int j = 0; j < 3; j++) {
                heroes.remove(0);
            }

            for (Element hero : heroes) {
                String heroName = hero.children().remove(0).text();
                String heroWinRate = hero.children().remove(2).text();
                double heroWinRateToDouble = Double.valueOf(heroWinRate.substring(0, heroWinRate.length() - 1));

                addingHeroToTierListByWinRateDiff(heroName, heroWinRateToDouble);
            }

            Hero.sortHeroes(originalHeroesWithTiers, 0, originalHeroesWithTiers.size() - 1, false);
            currentHeroesWithTiers.addAll(originalHeroesWithTiers);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private void addingHeroToTierListByWinRateDiff(String heroName, double heroWinRateToDouble) {
        if (heroWinRateToDouble > 55.0)
            originalHeroesWithTiers.add(
                    new Hero(getHeroImageByName(heroName), heroName, heroWinRateToDouble, "S", heroWinRateToDouble));
        else if (heroWinRateToDouble > 53.0)
            originalHeroesWithTiers.add(
                    new Hero(getHeroImageByName(heroName), heroName, heroWinRateToDouble, "A", heroWinRateToDouble));
        else if (heroWinRateToDouble > 51.0)
            originalHeroesWithTiers.add(
                    new Hero(getHeroImageByName(heroName), heroName, heroWinRateToDouble, "B", heroWinRateToDouble));
        else if (heroWinRateToDouble > 49.0)
            originalHeroesWithTiers.add(
                    new Hero(getHeroImageByName(heroName), heroName, heroWinRateToDouble, "C", heroWinRateToDouble));
        else if (heroWinRateToDouble > 47.0)
            originalHeroesWithTiers.add(
                    new Hero(getHeroImageByName(heroName), heroName, heroWinRateToDouble, "D", heroWinRateToDouble));
        else if (heroWinRateToDouble > 45.0)
            originalHeroesWithTiers.add(
                    new Hero(getHeroImageByName(heroName), heroName, heroWinRateToDouble, "E", heroWinRateToDouble));
        else
            originalHeroesWithTiers.add(
                    new Hero(getHeroImageByName(heroName), heroName, heroWinRateToDouble, "F", heroWinRateToDouble));
    }

    private int getHeroImageByName(String heroName) {
        switch (heroName) {
            case ("Abaddon"):
                return R.drawable.abaddon;
            case ("Alchemist"):
                return R.drawable.alchemist;
            case ("Ancient Apparition"):
                return R.drawable.ancient_apparition;
            case ("Anti-Mage"):
                return R.drawable.anti_mage;
            case ("Arc Warden"):
                return R.drawable.arc_warden;
            case ("Axe"):
                return R.drawable.axe;
            case ("Bane"):
                return R.drawable.bane;
            case ("Batrider"):
                return R.drawable.batrider;
            case ("Beastmaster"):
                return R.drawable.beastmaster;
            case ("Bloodseeker"):
                return R.drawable.bloodseeker;
            case ("Bounty Hunter"):
                return R.drawable.bounty_hunter;
            case ("Brewmaster"):
                return R.drawable.brewmaster;
            case ("Bristleback"):
                return R.drawable.bristleback;
            case ("Broodmother"):
                return R.drawable.broodmother;
            case ("Centaur Warrunner"):
                return R.drawable.centaur_warrunner;
            case ("Chaos Knight"):
                return R.drawable.chaos_knight;
            case ("Chen"):
                return R.drawable.chen;
            case ("Clinkz"):
                return R.drawable.clinkz;
            case ("Clockwerk"):
                return R.drawable.clockwerk;
            case ("Crystal Maiden"):
                return R.drawable.crystal_maiden;
            case ("Dark Seer"):
                return R.drawable.dark_seer;
            case ("Dark Willow"):
                return R.drawable.dark_willow;
            case ("Dazzle"):
                return R.drawable.dazzle;
            case ("Death Prophet"):
                return R.drawable.death_prophet;
            case ("Disruptor"):
                return R.drawable.disruptor;
            case ("Doom"):
                return R.drawable.doom;
            case ("Dragon Knight"):
                return R.drawable.dragon_knight;
            case ("Drow Ranger"):
                return R.drawable.drow_ranger;
            case ("Earth Spirit"):
                return R.drawable.earth_spirit;
            case ("Earthshaker"):
                return R.drawable.earthshaker;
            case ("Elder Titan"):
                return R.drawable.elder_titan;
            case ("Ember Spirit"):
                return R.drawable.ember_spirit;
            case ("Enchantress"):
                return R.drawable.enchantress;
            case ("Enigma"):
                return R.drawable.enigma;
            case ("Faceless Void"):
                return R.drawable.faceless_void;
            case ("Grimstroke"):
                return R.drawable.grimstroke;
            case ("Gyrocopter"):
                return R.drawable.gyrocopter;
            case ("Huskar"):
                return R.drawable.huskar;
            case ("Invoker"):
                return R.drawable.invoker;
            case ("Io"):
                return R.drawable.io;
            case ("Jakiro"):
                return R.drawable.jakiro;
            case ("Juggernaut"):
                return R.drawable.juggernaut;
            case ("Keeper of the Light"):
                return R.drawable.keeper_of_the_light;
            case ("Kunkka"):
                return R.drawable.kunkka;
            case ("Legion Commander"):
                return R.drawable.legion_commander;
            case ("Leshrac"):
                return R.drawable.leshrac;
            case ("Lich"):
                return R.drawable.lich;
            case ("Lifestealer"):
                return R.drawable.lifestealer;
            case ("Lina"):
                return R.drawable.lina;
            case ("Lion"):
                return R.drawable.lion;
            case ("Lone Druid"):
                return R.drawable.lone_druid;
            case ("Luna"):
                return R.drawable.luna;
            case ("Lycan"):
                return R.drawable.lycan;
            case ("Magnus"):
                return R.drawable.magnus;
            case ("Mars"):
                return R.drawable.mars;
            case ("Medusa"):
                return R.drawable.medusa;
            case ("Meepo"):
                return R.drawable.meepo;
            case ("Mirana"):
                return R.drawable.mirana;
            case ("Monkey King"):
                return R.drawable.monkey_king;
            case ("Morphling"):
                return R.drawable.morphling;
            case ("Naga Siren"):
                return R.drawable.naga_siren;
            case ("Nature's Prophet"):
                return R.drawable.natures_prophet;
            case ("Necrophos"):
                return R.drawable.necrophos;
            case ("Night Stalker"):
                return R.drawable.night_stalker;
            case ("Nyx Assassin"):
                return R.drawable.nyx_assassin;
            case ("Ogre Magi"):
                return R.drawable.ogre_magi;
            case ("Omniknight"):
                return R.drawable.omniknight;
            case ("Oracle"):
                return R.drawable.oracle;
            case ("Outworld Devourer"):
                return R.drawable.outworld_devourer;
            case ("Pangolier"):
                return R.drawable.pangolier;
            case ("Phantom Assassin"):
                return R.drawable.phantom_assassin;
            case ("Phantom Lancer"):
                return R.drawable.phantom_lancer;
            case ("Phoenix"):
                return R.drawable.phoenix;
            case ("Puck"):
                return R.drawable.puck;
            case ("Pudge"):
                return R.drawable.pudge;
            case ("Pugna"):
                return R.drawable.pugna;
            case ("Queen of Pain"):
                return R.drawable.queen_of_pain;
            case ("Razor"):
                return R.drawable.razor;
            case ("Riki"):
                return R.drawable.riki;
            case ("Rubick"):
                return R.drawable.rubick;
            case ("Sand King"):
                return R.drawable.sand_king;
            case ("Shadow Demon"):
                return R.drawable.shadow_demon;
            case ("Shadow Fiend"):
                return R.drawable.shadow_fiend;
            case ("Shadow Shaman"):
                return R.drawable.shadow_shaman;
            case ("Silencer"):
                return R.drawable.silencer;
            case ("Skywrath Mage"):
                return R.drawable.skywrath_mage;
            case ("Slardar"):
                return R.drawable.slardar;
            case ("Slark"):
                return R.drawable.slark;
            case ("Sniper"):
                return R.drawable.sniper;
            case ("Spectre"):
                return R.drawable.spectre;
            case ("Spirit Breaker"):
                return R.drawable.spirit_breaker;
            case ("Storm Spirit"):
                return R.drawable.storm_spirit;
            case ("Sven"):
                return R.drawable.sven;
            case ("Techies"):
                return R.drawable.techies;
            case ("Templar Assassin"):
                return R.drawable.templar_assassin;
            case ("Terrorblade"):
                return R.drawable.terrorblade;
            case ("Tidehunter"):
                return R.drawable.tidehunter;
            case ("Timbersaw"):
                return R.drawable.timbersaw;
            case ("Tinker"):
                return R.drawable.tinker;
            case ("Tiny"):
                return R.drawable.tiny;
            case ("Treant Protector"):
                return R.drawable.treant_protector;
            case ("Troll Warlord"):
                return R.drawable.troll_warlord;
            case ("Tusk"):
                return R.drawable.tusk;
            case ("Underlord"):
                return R.drawable.underlord;
            case ("Undying"):
                return R.drawable.undying;
            case ("Ursa"):
                return R.drawable.ursa;
            case ("Vengeful Spirit"):
                return R.drawable.vengeful_spirit;
            case ("Venomancer"):
                return R.drawable.venomancer;
            case ("Viper"):
                return R.drawable.viper;
            case ("Visage"):
                return R.drawable.visage;
            case ("Warlock"):
                return R.drawable.warlock;
            case ("Weaver"):
                return R.drawable.weaver;
            case ("Windranger"):
                return R.drawable.windranger;
            case ("Winter Wyvern"):
                return R.drawable.winter_wyvern;
            case ("Witch Doctor"):
                return R.drawable.witch_doctor;
            case ("Wraith King"):
                return R.drawable.wraith_king;
            case ("Zeus"):
                return R.drawable.zeus;
            default:
                return R.drawable.frame;
        }
    }
}