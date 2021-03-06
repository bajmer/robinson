package model;

import model.enums.PhaseType;
import model.enums.ProfessionType;
import model.enums.SpecialSkillType;
import model.enums.TerrainType;
import model.enums.cards.BeastType;
import model.enums.cards.InventionType;
import model.enums.cards.adventurecards.AdventureEventEffectType;
import model.enums.cards.adventurecards.BuildingAdventureType;
import model.enums.cards.adventurecards.ExplorationAdventureType;
import model.enums.cards.adventurecards.GatheringResourcesAdventureType;
import model.enums.cards.eventcards.EventEffectType;
import model.enums.cards.eventcards.EventIconType;
import model.enums.cards.eventcards.ThreatActionType;
import model.enums.cards.eventcards.ThreatEffectType;
import model.enums.elements.DiceType;
import model.enums.elements.MarkerType;
import model.enums.elements.ResourceType;

import java.util.*;

import static model.enums.PhaseType.*;
import static model.enums.ProfessionType.*;
import static model.enums.SpecialSkillType.*;
import static model.enums.TerrainType.*;
import static model.enums.cards.BeastType.*;
import static model.enums.cards.InventionType.*;
import static model.enums.cards.adventurecards.AdventureEventEffectType.SOME_ADVENTURE_EVENT_EFFECT;
import static model.enums.cards.adventurecards.BuildingAdventureType.*;
import static model.enums.cards.adventurecards.ExplorationAdventureType.*;
import static model.enums.cards.adventurecards.GatheringResourcesAdventureType.*;
import static model.enums.cards.eventcards.EventEffectType.*;
import static model.enums.cards.eventcards.EventIconType.*;
import static model.enums.cards.eventcards.ThreatActionType.THREAT_ACTION;
import static model.enums.cards.eventcards.ThreatEffectType.THREAT_EFFECT;
import static model.enums.elements.DiceType.*;
import static model.enums.elements.MarkerType.*;
import static model.enums.elements.ResourceType.FOOD;
import static model.enums.elements.ResourceType.WOOD;

public class Mappings {
    private static Map<EventEffectType, EventIconType> eventEffectToEventIconMapping = new HashMap<>();
    private static Map<EventEffectType, ThreatActionType> eventEffectToThreatActionMapping = new HashMap<>();
    private static Map<EventEffectType, ThreatEffectType> eventEffectToThreatEffectMapping = new HashMap<>();
    private static Map<BuildingAdventureType, AdventureEventEffectType> buildingAdvntureToAdventureEventEffectMapping = new HashMap<>();
    private static Map<GatheringResourcesAdventureType, AdventureEventEffectType> gatheringAdventureToAdventureEventEffectMapping = new HashMap<>();
    private static Map<ExplorationAdventureType, AdventureEventEffectType> explorationAdventureToAdventureEventEffectMapping = new HashMap<>();
    private static Map<BeastType, List<Integer>> beastToBeastStatsMapping = new HashMap<>();
    private static Map<Integer, Integer> scenarioIdToRoundsNumberMapping = new HashMap<>();
    private static Map<Integer, Map<Integer, List<DiceType>>> scenarioIdToRoundWeatherDicesMapMapping = new HashMap<>();
    private static Map<Integer, List<DiceType>> scenario1RoundIdToWeatherDicesList = new HashMap<>();
    private static Map<Integer, List<DiceType>> scenario2RoundIdToWeatherDicesList = new HashMap<>();
    private static Map<Integer, List<DiceType>> scenario3RoundIdToWeatherDicesList = new HashMap<>();
    private static Map<Integer, List<DiceType>> scenario4RoundIdToWeatherDicesList = new HashMap<>();
    private static Map<Integer, List<DiceType>> scenario5RoundIdToWeatherDicesList = new HashMap<>();
    private static Map<Integer, List<DiceType>> scenario6RoundIdToWeatherDicesList = new HashMap<>();
    private static Map<Integer, List<DiceType>> scenario7RoundIdToWeatherDicesList = new HashMap<>();
    private static Map<Integer, List<InventionType>> scenarioIdToInventionMapping = new HashMap<>();
    private static Map<InventionType, Boolean> inventionToIsMandatoryMapping = new HashMap<>();
    private static Map<InventionType, Boolean> inventionToMultipleInventionMapping = new HashMap<>();
    private static Map<InventionType, ProfessionType> inventionToOwnerMapping = new HashMap<>();
    private static Map<ProfessionType, List<SpecialSkillType>> professionToSpecialSkillMapping = new HashMap<>();
    private static Map<ProfessionType, InventionType> professionToPersonalInventionMapping = new HashMap<>();
    private static Map<ProfessionType, List<Integer>> professionToMoraleDownMapping = new HashMap<>();
    private static Map<ProfessionType, Integer> professionToLifeMapping = new HashMap<>();
    private static Map<ProfessionType, MarkerType> professionToMarkerMapping = new HashMap<>();
    private static Map<Integer, TerrainType> islandTileIdToTerrainMapping = new HashMap<>();
    private static Map<Integer, ResourceType> islandTileIdToLeftSquareResourceMapping = new HashMap<>();
    private static Map<Integer, ResourceType> islandTileIdToRightSquareResourceMapping = new HashMap<>();
    private static Map<Integer, Boolean> islandTileIdToHasAnimalSourceMapping = new HashMap<>();
    private static Map<Integer, Integer> islandTileIdToTotemsNumberMapping = new HashMap<>();
    private static Map<Integer, Integer> islandTileIdToDiscoveryTokensNumberMapping = new HashMap<>();
    private static Map<Integer, Boolean> islandTileIdToHasNaturalShelterMapping = new HashMap<>();
    private static Map<PhaseType, PhaseType> currentPhaseToNextPhaseMapping = new HashMap<>();
    public Mappings() {

        eventEffectToEventIconMapping.put(FOOD_CRATES, null);
        eventEffectToEventIconMapping.put(WRECKED_LIFEBOAT, null);
        eventEffectToEventIconMapping.put(CAPTAINS_CHEST, null);
        eventEffectToEventIconMapping.put(WINTER_DEPRESSION, BOOK);
        eventEffectToEventIconMapping.put(CHRONIC_TIREDNESS, BOOK);
        eventEffectToEventIconMapping.put(HIGH_WATER, BOOK);
        eventEffectToEventIconMapping.put(FROST, BOOK);
        eventEffectToEventIconMapping.put(WRECKED_BALLOON, BOOK);
        eventEffectToEventIconMapping.put(PREDATORS_IN_THE_VICINITY, BOOK);
        eventEffectToEventIconMapping.put(NIGHT_HOWLING, BOOK);
        eventEffectToEventIconMapping.put(POISONING, BOOK);
        eventEffectToEventIconMapping.put(CULLED_AREA, BOOK);
        eventEffectToEventIconMapping.put(BODY_ON_THE_BEACH, BOOK);
        eventEffectToEventIconMapping.put(COLD_RAIN_1, BOOK);
        eventEffectToEventIconMapping.put(COLD_RAIN_2, BOOK);
        eventEffectToEventIconMapping.put(MEMORIES_OF_THE_CRUISE, BUILDING_ADVENTURE);
        eventEffectToEventIconMapping.put(THUNDERSTORM, BUILDING_ADVENTURE);
        eventEffectToEventIconMapping.put(PREDATORS, BUILDING_ADVENTURE);
        eventEffectToEventIconMapping.put(CALL_OF_THE_WILD, BOOK);
        eventEffectToEventIconMapping.put(EARTHQUAKE, BOOK);
        eventEffectToEventIconMapping.put(DESTRUCTIVE_HURRICANE, GATHERING_RESOURCES_ADVENTURE);
        eventEffectToEventIconMapping.put(LANDSLIDE, BUILDING_ADVENTURE);
        eventEffectToEventIconMapping.put(BAD_FEELINGS, EXPLORATION_ADVENTURE);
        eventEffectToEventIconMapping.put(MESS_IN_THE_CAMP, BUILDING_ADVENTURE);
        eventEffectToEventIconMapping.put(THE_ISLAND_REBELS_AGAINST_YOU, BOOK);
        eventEffectToEventIconMapping.put(NATURAL_DAM_BREAKS, GATHERING_RESOURCES_ADVENTURE);
        eventEffectToEventIconMapping.put(RAGING_RIVER, BOOK);
        eventEffectToEventIconMapping.put(FLOOD, BOOK);
        eventEffectToEventIconMapping.put(VERTIGO, BOOK);
        eventEffectToEventIconMapping.put(HEAVY_RAIN, BOOK);
        eventEffectToEventIconMapping.put(WEAKNESS, GATHERING_RESOURCES_ADVENTURE);
        eventEffectToEventIconMapping.put(SLOW_WORK, BOOK);
        eventEffectToEventIconMapping.put(RAIN, EXPLORATION_ADVENTURE);
        eventEffectToEventIconMapping.put(PREDATORS_IN_THE_WOODS, BOOK);
        eventEffectToEventIconMapping.put(BAD_FATE, GATHERING_RESOURCES_ADVENTURE);
        eventEffectToEventIconMapping.put(EventEffectType.BEAR, BOOK);
        eventEffectToEventIconMapping.put(CATACLYSM, BUILDING_ADVENTURE);
        eventEffectToEventIconMapping.put(SEARCHING_FOR_A_NEW_PATH, BOOK);
        eventEffectToEventIconMapping.put(FIGHT, EXPLORATION_ADVENTURE);
        eventEffectToEventIconMapping.put(ARGUMENT, BOOK);
        eventEffectToEventIconMapping.put(CLOUD_BURST, BUILDING_ADVENTURE);
        eventEffectToEventIconMapping.put(HEAVY_CLOUDS, BOOK);
        eventEffectToEventIconMapping.put(RAVAGING_HURRICANE, GATHERING_RESOURCES_ADVENTURE);
        eventEffectToEventIconMapping.put(RAVISHING_WINDSTORM, BUILDING_ADVENTURE);
        eventEffectToEventIconMapping.put(EventEffectType.FIRE, BOOK);
        eventEffectToEventIconMapping.put(SLEEPLESS_NIGHT, GATHERING_RESOURCES_ADVENTURE);
        eventEffectToEventIconMapping.put(PREDATOR_IS_NEAR, BOOK);
        eventEffectToEventIconMapping.put(STORM_1, BOOK);
        eventEffectToEventIconMapping.put(STORM_2, EXPLORATION_ADVENTURE);
        eventEffectToEventIconMapping.put(EXHAUSTING_NIGHT, GATHERING_RESOURCES_ADVENTURE);
        eventEffectToEventIconMapping.put(BROKEN_TREE, EXPLORATION_ADVENTURE);
        eventEffectToEventIconMapping.put(STRONG_WIND, BOOK);
        eventEffectToEventIconMapping.put(EventEffectType.WEATHER_BREAKDOWN, EXPLORATION_ADVENTURE);
        eventEffectToEventIconMapping.put(MIST, EXPLORATION_ADVENTURE);
        eventEffectToEventIconMapping.put(DEPRESSION, BOOK);
        eventEffectToEventIconMapping.put(DISASTER, BUILDING_ADVENTURE);
        eventEffectToEventIconMapping.put(FLYING_SURPRISE, BOOK);
        eventEffectToEventIconMapping.put(DEVASTATING_BLOWS, GATHERING_RESOURCES_ADVENTURE);
        eventEffectToEventIconMapping.put(EventEffectType.LACK_OF_HOPE, BOOK);
        eventEffectToEventIconMapping.put(LOSS_OF_HOPE, EXPLORATION_ADVENTURE);
        eventEffectToEventIconMapping.put(FIGHT_IN_THE_DARK, BUILDING_ADVENTURE);
        eventEffectToEventIconMapping.put(DANGEROUS_NIGHT, BOOK);
        eventEffectToEventIconMapping.put(NIGHT_ATTACK, BUILDING_ADVENTURE);
        eventEffectToEventIconMapping.put(HOWLING_FROM_THE_WOODS, GATHERING_RESOURCES_ADVENTURE);
        eventEffectToEventIconMapping.put(SMOKE_ON_THE_HORIZON, BOOK);
        eventEffectToEventIconMapping.put(DROUGHT, EXPLORATION_ADVENTURE);
        eventEffectToEventIconMapping.put(ROUGH_PASSAGE, GATHERING_RESOURCES_ADVENTURE);
        eventEffectToEventIconMapping.put(UNUSUALLY_COLD_NIGHT, BOOK);
        eventEffectToEventIconMapping.put(COUNCIL, BUILDING_ADVENTURE);
        eventEffectToEventIconMapping.put(INSECTS, BOOK);
        eventEffectToEventIconMapping.put(HEAVY_RAIN_IS_COMING, EXPLORATION_ADVENTURE);
        eventEffectToEventIconMapping.put(AWFUL_WEATHER, EXPLORATION_ADVENTURE);
        eventEffectToEventIconMapping.put(PRECIPICE, BOOK);
        eventEffectToEventIconMapping.put(EventEffectType.JAGUAR, BUILDING_ADVENTURE);
        eventEffectToEventIconMapping.put(RAVENOUS_PREDATORS, BOOK);
        eventEffectToEventIconMapping.put(OTTERS, GATHERING_RESOURCES_ADVENTURE);

        eventEffectToThreatActionMapping.put(FOOD_CRATES, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(WRECKED_LIFEBOAT, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(CAPTAINS_CHEST, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(WINTER_DEPRESSION, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(CHRONIC_TIREDNESS, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(HIGH_WATER, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(FROST, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(WRECKED_BALLOON, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(PREDATORS_IN_THE_VICINITY, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(NIGHT_HOWLING, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(POISONING, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(CULLED_AREA, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(BODY_ON_THE_BEACH, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(COLD_RAIN_1, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(COLD_RAIN_2, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(MEMORIES_OF_THE_CRUISE, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(THUNDERSTORM, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(PREDATORS, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(CALL_OF_THE_WILD, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(EARTHQUAKE, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(DESTRUCTIVE_HURRICANE, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(LANDSLIDE, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(BAD_FEELINGS, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(MESS_IN_THE_CAMP, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(THE_ISLAND_REBELS_AGAINST_YOU, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(NATURAL_DAM_BREAKS, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(RAGING_RIVER, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(FLOOD, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(VERTIGO, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(HEAVY_RAIN, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(WEAKNESS, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(SLOW_WORK, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(RAIN, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(PREDATORS_IN_THE_WOODS, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(BAD_FATE, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(EventEffectType.BEAR, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(CATACLYSM, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(SEARCHING_FOR_A_NEW_PATH, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(FIGHT, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(ARGUMENT, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(CLOUD_BURST, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(HEAVY_CLOUDS, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(RAVAGING_HURRICANE, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(RAVISHING_WINDSTORM, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(EventEffectType.FIRE, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(SLEEPLESS_NIGHT, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(PREDATOR_IS_NEAR, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(STORM_1, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(STORM_2, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(EXHAUSTING_NIGHT, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(BROKEN_TREE, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(STRONG_WIND, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(EventEffectType.WEATHER_BREAKDOWN, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(MIST, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(DEPRESSION, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(DISASTER, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(FLYING_SURPRISE, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(DEVASTATING_BLOWS, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(EventEffectType.LACK_OF_HOPE, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(LOSS_OF_HOPE, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(FIGHT_IN_THE_DARK, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(DANGEROUS_NIGHT, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(NIGHT_ATTACK, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(HOWLING_FROM_THE_WOODS, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(SMOKE_ON_THE_HORIZON, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(DROUGHT, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(ROUGH_PASSAGE, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(UNUSUALLY_COLD_NIGHT, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(COUNCIL, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(INSECTS, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(HEAVY_RAIN_IS_COMING, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(AWFUL_WEATHER, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(PRECIPICE, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(EventEffectType.JAGUAR, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(RAVENOUS_PREDATORS, THREAT_ACTION);
        eventEffectToThreatActionMapping.put(OTTERS, THREAT_ACTION);

        eventEffectToThreatEffectMapping.put(FOOD_CRATES, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(WRECKED_LIFEBOAT, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(CAPTAINS_CHEST, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(WINTER_DEPRESSION, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(CHRONIC_TIREDNESS, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(HIGH_WATER, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(FROST, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(WRECKED_BALLOON, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(PREDATORS_IN_THE_VICINITY, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(NIGHT_HOWLING, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(POISONING, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(CULLED_AREA, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(BODY_ON_THE_BEACH, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(COLD_RAIN_1, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(COLD_RAIN_2, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(MEMORIES_OF_THE_CRUISE, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(THUNDERSTORM, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(PREDATORS, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(CALL_OF_THE_WILD, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(EARTHQUAKE, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(DESTRUCTIVE_HURRICANE, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(LANDSLIDE, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(BAD_FEELINGS, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(MESS_IN_THE_CAMP, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(THE_ISLAND_REBELS_AGAINST_YOU, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(NATURAL_DAM_BREAKS, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(RAGING_RIVER, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(FLOOD, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(VERTIGO, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(HEAVY_RAIN, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(WEAKNESS, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(SLOW_WORK, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(RAIN, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(PREDATORS_IN_THE_WOODS, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(BAD_FATE, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(EventEffectType.BEAR, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(CATACLYSM, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(SEARCHING_FOR_A_NEW_PATH, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(FIGHT, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(ARGUMENT, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(CLOUD_BURST, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(HEAVY_CLOUDS, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(RAVAGING_HURRICANE, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(RAVISHING_WINDSTORM, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(EventEffectType.FIRE, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(SLEEPLESS_NIGHT, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(PREDATOR_IS_NEAR, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(STORM_1, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(STORM_2, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(EXHAUSTING_NIGHT, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(BROKEN_TREE, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(STRONG_WIND, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(EventEffectType.WEATHER_BREAKDOWN, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(MIST, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(DEPRESSION, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(DISASTER, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(FLYING_SURPRISE, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(DEVASTATING_BLOWS, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(EventEffectType.LACK_OF_HOPE, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(LOSS_OF_HOPE, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(FIGHT_IN_THE_DARK, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(DANGEROUS_NIGHT, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(NIGHT_ATTACK, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(HOWLING_FROM_THE_WOODS, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(SMOKE_ON_THE_HORIZON, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(DROUGHT, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(ROUGH_PASSAGE, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(UNUSUALLY_COLD_NIGHT, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(COUNCIL, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(INSECTS, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(HEAVY_RAIN_IS_COMING, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(AWFUL_WEATHER, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(PRECIPICE, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(EventEffectType.JAGUAR, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(RAVENOUS_PREDATORS, THREAT_EFFECT);
        eventEffectToThreatEffectMapping.put(OTTERS, THREAT_EFFECT);

        buildingAdvntureToAdventureEventEffectMapping.put(TOOL_BREAKS, SOME_ADVENTURE_EVENT_EFFECT);
        buildingAdvntureToAdventureEventEffectMapping.put(LABORIOUS_WORK_1, SOME_ADVENTURE_EVENT_EFFECT);
        buildingAdvntureToAdventureEventEffectMapping.put(LABORIOUS_WORK_2, SOME_ADVENTURE_EVENT_EFFECT);
        buildingAdvntureToAdventureEventEffectMapping.put(CONSTRUCTION, SOME_ADVENTURE_EVENT_EFFECT);
        buildingAdvntureToAdventureEventEffectMapping.put(UNMOTIVATED, SOME_ADVENTURE_EVENT_EFFECT);
        buildingAdvntureToAdventureEventEffectMapping.put(FAST_WORK, SOME_ADVENTURE_EVENT_EFFECT);
        buildingAdvntureToAdventureEventEffectMapping.put(STING, SOME_ADVENTURE_EVENT_EFFECT);
        buildingAdvntureToAdventureEventEffectMapping.put(NASTY_WOUND, SOME_ADVENTURE_EVENT_EFFECT);
        buildingAdvntureToAdventureEventEffectMapping.put(TIRED, SOME_ADVENTURE_EVENT_EFFECT);
        buildingAdvntureToAdventureEventEffectMapping.put(IN_A_HURRY, SOME_ADVENTURE_EVENT_EFFECT);
        buildingAdvntureToAdventureEventEffectMapping.put(DARK_CLOUDS_IN_THE_SKY, SOME_ADVENTURE_EVENT_EFFECT);
        buildingAdvntureToAdventureEventEffectMapping.put(CONSTRUCTION_IS_WEAK, SOME_ADVENTURE_EVENT_EFFECT);
        buildingAdvntureToAdventureEventEffectMapping.put(PREDATOR_IN_THE_CAMP, SOME_ADVENTURE_EVENT_EFFECT);
        buildingAdvntureToAdventureEventEffectMapping.put(WIND_STORM, SOME_ADVENTURE_EVENT_EFFECT);
        buildingAdvntureToAdventureEventEffectMapping.put(FEAR_OF_THE_BEASTS, SOME_ADVENTURE_EVENT_EFFECT);
        buildingAdvntureToAdventureEventEffectMapping.put(BREAKDOWN, SOME_ADVENTURE_EVENT_EFFECT);
        buildingAdvntureToAdventureEventEffectMapping.put(BROKEN_LEVER, SOME_ADVENTURE_EVENT_EFFECT);
        buildingAdvntureToAdventureEventEffectMapping.put(DANGEROUS_WORK, SOME_ADVENTURE_EVENT_EFFECT);
        buildingAdvntureToAdventureEventEffectMapping.put(BuildingAdventureType.LACK_OF_HOPE, SOME_ADVENTURE_EVENT_EFFECT);
        buildingAdvntureToAdventureEventEffectMapping.put(HARD_WORK, SOME_ADVENTURE_EVENT_EFFECT);
        buildingAdvntureToAdventureEventEffectMapping.put(COMING_TO_TERMS, SOME_ADVENTURE_EVENT_EFFECT);
        buildingAdvntureToAdventureEventEffectMapping.put(CUT_HEAD, SOME_ADVENTURE_EVENT_EFFECT);
        buildingAdvntureToAdventureEventEffectMapping.put(TOOLS_INSPECTION, SOME_ADVENTURE_EVENT_EFFECT);
        buildingAdvntureToAdventureEventEffectMapping.put(MONKEYS_WATCH_YOU, SOME_ADVENTURE_EVENT_EFFECT);
        buildingAdvntureToAdventureEventEffectMapping.put(SAVINGS, SOME_ADVENTURE_EVENT_EFFECT);
        buildingAdvntureToAdventureEventEffectMapping.put(ACCIDENT, SOME_ADVENTURE_EVENT_EFFECT);
        buildingAdvntureToAdventureEventEffectMapping.put(HOWLING_IN_THE_BUSHES, SOME_ADVENTURE_EVENT_EFFECT);
        buildingAdvntureToAdventureEventEffectMapping.put(HUNGRY_PREDATOR, SOME_ADVENTURE_EVENT_EFFECT);
        buildingAdvntureToAdventureEventEffectMapping.put(YOU_NEED_A_BIGGER_CAMP, SOME_ADVENTURE_EVENT_EFFECT);
        buildingAdvntureToAdventureEventEffectMapping.put(VISIT_OF_A_PREDATOR, SOME_ADVENTURE_EVENT_EFFECT);

        gatheringAdventureToAdventureEventEffectMapping.put(END_OF_SOURCE_1, SOME_ADVENTURE_EVENT_EFFECT);
        gatheringAdventureToAdventureEventEffectMapping.put(END_OF_SOURCE_2, SOME_ADVENTURE_EVENT_EFFECT);
        gatheringAdventureToAdventureEventEffectMapping.put(END_OF_SOURCE_3, SOME_ADVENTURE_EVENT_EFFECT);
        gatheringAdventureToAdventureEventEffectMapping.put(END_OF_SOURCE_4, SOME_ADVENTURE_EVENT_EFFECT);
        gatheringAdventureToAdventureEventEffectMapping.put(END_OF_SOURCE_5, SOME_ADVENTURE_EVENT_EFFECT);
        gatheringAdventureToAdventureEventEffectMapping.put(WINTER_FREEZING, SOME_ADVENTURE_EVENT_EFFECT);
        gatheringAdventureToAdventureEventEffectMapping.put(UNEXPECTED_DISCOVERY, SOME_ADVENTURE_EVENT_EFFECT);
        gatheringAdventureToAdventureEventEffectMapping.put(FURS, SOME_ADVENTURE_EVENT_EFFECT);
        gatheringAdventureToAdventureEventEffectMapping.put(SPIDER, SOME_ADVENTURE_EVENT_EFFECT);
        gatheringAdventureToAdventureEventEffectMapping.put(SKELETON, SOME_ADVENTURE_EVENT_EFFECT);
        gatheringAdventureToAdventureEventEffectMapping.put(SIGNS_OF_A_PREDATOR, SOME_ADVENTURE_EVENT_EFFECT);
        gatheringAdventureToAdventureEventEffectMapping.put(PIRATES_CHEST, SOME_ADVENTURE_EVENT_EFFECT);
        gatheringAdventureToAdventureEventEffectMapping.put(VIPER, SOME_ADVENTURE_EVENT_EFFECT);
        gatheringAdventureToAdventureEventEffectMapping.put(UNBELIEVABLE_EFFORT, SOME_ADVENTURE_EVENT_EFFECT);
        gatheringAdventureToAdventureEventEffectMapping.put(TWISTED_ANKLE, SOME_ADVENTURE_EVENT_EFFECT);
        gatheringAdventureToAdventureEventEffectMapping.put(WINTER_IS_COMING, SOME_ADVENTURE_EVENT_EFFECT);
        gatheringAdventureToAdventureEventEffectMapping.put(GatheringResourcesAdventureType.WEATHER_BREAKDOWN, SOME_ADVENTURE_EVENT_EFFECT);
        gatheringAdventureToAdventureEventEffectMapping.put(UNEXPECTED_TROUBLES, SOME_ADVENTURE_EVENT_EFFECT);
        gatheringAdventureToAdventureEventEffectMapping.put(TRACKS_OF_A_PREDATOR, SOME_ADVENTURE_EVENT_EFFECT);
        gatheringAdventureToAdventureEventEffectMapping.put(SHORTAGE, SOME_ADVENTURE_EVENT_EFFECT);
        gatheringAdventureToAdventureEventEffectMapping.put(MUSHROOMS, SOME_ADVENTURE_EVENT_EFFECT);
        gatheringAdventureToAdventureEventEffectMapping.put(GOLD_COIN, SOME_ADVENTURE_EVENT_EFFECT);
        gatheringAdventureToAdventureEventEffectMapping.put(FRUIT, SOME_ADVENTURE_EVENT_EFFECT);
        gatheringAdventureToAdventureEventEffectMapping.put(EYES_IN_THE_BUSHES, SOME_ADVENTURE_EVENT_EFFECT);
        gatheringAdventureToAdventureEventEffectMapping.put(AFTER_THE_HURRICANE, SOME_ADVENTURE_EVENT_EFFECT);
        gatheringAdventureToAdventureEventEffectMapping.put(PATH_OF_A_PREDATOR, SOME_ADVENTURE_EVENT_EFFECT);
        gatheringAdventureToAdventureEventEffectMapping.put(NICE_SURPRISE, SOME_ADVENTURE_EVENT_EFFECT);
        gatheringAdventureToAdventureEventEffectMapping.put(NESTLINGS, SOME_ADVENTURE_EVENT_EFFECT);
        gatheringAdventureToAdventureEventEffectMapping.put(NEW_FLOCK, SOME_ADVENTURE_EVENT_EFFECT);
        gatheringAdventureToAdventureEventEffectMapping.put(SURPRISE_IN_THE_BUSHES, SOME_ADVENTURE_EVENT_EFFECT);

        explorationAdventureToAdventureEventEffectMapping.put(WRONG_TRACK, SOME_ADVENTURE_EVENT_EFFECT);
        explorationAdventureToAdventureEventEffectMapping.put(SWAMP, SOME_ADVENTURE_EVENT_EFFECT);
        explorationAdventureToAdventureEventEffectMapping.put(SURPRISING_DISCOVERY, SOME_ADVENTURE_EVENT_EFFECT);
        explorationAdventureToAdventureEventEffectMapping.put(ITS_GOING_TO_RAIN, SOME_ADVENTURE_EVENT_EFFECT);
        explorationAdventureToAdventureEventEffectMapping.put(THERES_SOMETHING_IN_THE_AIR, SOME_ADVENTURE_EVENT_EFFECT);
        explorationAdventureToAdventureEventEffectMapping.put(BAMBOO, SOME_ADVENTURE_EVENT_EFFECT);
        explorationAdventureToAdventureEventEffectMapping.put(OLD_HUT, SOME_ADVENTURE_EVENT_EFFECT);
        explorationAdventureToAdventureEventEffectMapping.put(OLD_GRAVE, SOME_ADVENTURE_EVENT_EFFECT);
        explorationAdventureToAdventureEventEffectMapping.put(SIGNS_OF_FIRE_1, SOME_ADVENTURE_EVENT_EFFECT);
        explorationAdventureToAdventureEventEffectMapping.put(SHRINE, SOME_ADVENTURE_EVENT_EFFECT);
        explorationAdventureToAdventureEventEffectMapping.put(WILD_BERRIES, SOME_ADVENTURE_EVENT_EFFECT);
        explorationAdventureToAdventureEventEffectMapping.put(VIPERS, SOME_ADVENTURE_EVENT_EFFECT);
        explorationAdventureToAdventureEventEffectMapping.put(SECRET_CAVE, SOME_ADVENTURE_EVENT_EFFECT);
        explorationAdventureToAdventureEventEffectMapping.put(ExplorationAdventureType.PUMA, SOME_ADVENTURE_EVENT_EFFECT);
        explorationAdventureToAdventureEventEffectMapping.put(ExplorationAdventureType.TIGER, SOME_ADVENTURE_EVENT_EFFECT);
        explorationAdventureToAdventureEventEffectMapping.put(STORM_ON_THE_HORIZON, SOME_ADVENTURE_EVENT_EFFECT);
        explorationAdventureToAdventureEventEffectMapping.put(LOST, SOME_ADVENTURE_EVENT_EFFECT);
        explorationAdventureToAdventureEventEffectMapping.put(LOST_IN_THE_WOODS, SOME_ADVENTURE_EVENT_EFFECT);
        explorationAdventureToAdventureEventEffectMapping.put(LOST_IN_THE_THICKET, SOME_ADVENTURE_EVENT_EFFECT);
        explorationAdventureToAdventureEventEffectMapping.put(DANGEROUS_TERRAIN, SOME_ADVENTURE_EVENT_EFFECT);
        explorationAdventureToAdventureEventEffectMapping.put(FLU, SOME_ADVENTURE_EVENT_EFFECT);
        explorationAdventureToAdventureEventEffectMapping.put(EMPTY_FOREST, SOME_ADVENTURE_EVENT_EFFECT);
        explorationAdventureToAdventureEventEffectMapping.put(COLD_WIND, SOME_ADVENTURE_EVENT_EFFECT);
        explorationAdventureToAdventureEventEffectMapping.put(CARCASS, SOME_ADVENTURE_EVENT_EFFECT);
        explorationAdventureToAdventureEventEffectMapping.put(RUINED_HUT, SOME_ADVENTURE_EVENT_EFFECT);
        explorationAdventureToAdventureEventEffectMapping.put(REMAINS_OF_A_SETTLEMENT, SOME_ADVENTURE_EVENT_EFFECT);
        explorationAdventureToAdventureEventEffectMapping.put(THORNY_BUSH, SOME_ADVENTURE_EVENT_EFFECT);
        explorationAdventureToAdventureEventEffectMapping.put(MISADVENTURE, SOME_ADVENTURE_EVENT_EFFECT);
        explorationAdventureToAdventureEventEffectMapping.put(ExplorationAdventureType.WILD_DOG, SOME_ADVENTURE_EVENT_EFFECT);
        explorationAdventureToAdventureEventEffectMapping.put(SIGNS_OF_FIRE_2, SOME_ADVENTURE_EVENT_EFFECT);

        beastToBeastStatsMapping.put(ALLIGATOR, new ArrayList<>(Arrays.asList(6, -2, 3, 0)));
        beastToBeastStatsMapping.put(BeastType.BEAR, new ArrayList<>(Arrays.asList(6, -1, 5, 2)));
        beastToBeastStatsMapping.put(BIRDS, new ArrayList<>(Arrays.asList(1, 0, 2, 0)));
        beastToBeastStatsMapping.put(BOA, new ArrayList<>(Arrays.asList(2, -2, 2, 0)));
        beastToBeastStatsMapping.put(CHAMOIS, new ArrayList<>(Arrays.asList(5, -1, 3, 2)));
        beastToBeastStatsMapping.put(CHEETAH, new ArrayList<>(Arrays.asList(4, -1, 2, 1)));
        beastToBeastStatsMapping.put(FOX, new ArrayList<>(Arrays.asList(2, 0, 2, 1)));
        beastToBeastStatsMapping.put(GOATS, new ArrayList<>(Arrays.asList(4, -1, 3, 1)));
        beastToBeastStatsMapping.put(GORILLA, new ArrayList<>(Arrays.asList(6, -3, 5, 2)));
        beastToBeastStatsMapping.put(IGUANA, new ArrayList<>(Arrays.asList(4, -1, 3, 1)));
        beastToBeastStatsMapping.put(BeastType.JAGUAR, new ArrayList<>(Arrays.asList(5, 0, 4, 1)));
        beastToBeastStatsMapping.put(BeastType.PUMA, new ArrayList<>(Arrays.asList(5, 0, 2, 1)));
        beastToBeastStatsMapping.put(TAPIR, new ArrayList<>(Arrays.asList(3, -1, 2, 1)));
        beastToBeastStatsMapping.put(BeastType.TIGER, new ArrayList<>(Arrays.asList(6, -2, 5, 2)));
        beastToBeastStatsMapping.put(BeastType.WILD_DOG, new ArrayList<>(Arrays.asList(3, 0, 2, 1)));
        beastToBeastStatsMapping.put(WILD_PIG, new ArrayList<>(Arrays.asList(3, -1, 3, 1)));

        scenarioIdToRoundsNumberMapping.put(1, 12);
        scenarioIdToRoundsNumberMapping.put(2, 10);
        scenarioIdToRoundsNumberMapping.put(3, 8);
        scenarioIdToRoundsNumberMapping.put(4, 12);
        scenarioIdToRoundsNumberMapping.put(5, 12);
        scenarioIdToRoundsNumberMapping.put(6, 12);
        scenarioIdToRoundsNumberMapping.put(7, 12);

        scenarioIdToRoundWeatherDicesMapMapping.put(1, scenario1RoundIdToWeatherDicesList);
        scenarioIdToRoundWeatherDicesMapMapping.put(2, scenario2RoundIdToWeatherDicesList);
        scenarioIdToRoundWeatherDicesMapMapping.put(3, scenario3RoundIdToWeatherDicesList);
        scenarioIdToRoundWeatherDicesMapMapping.put(4, scenario4RoundIdToWeatherDicesList);
        scenarioIdToRoundWeatherDicesMapMapping.put(5, scenario5RoundIdToWeatherDicesList);
        scenarioIdToRoundWeatherDicesMapMapping.put(6, scenario6RoundIdToWeatherDicesList);
        scenarioIdToRoundWeatherDicesMapMapping.put(7, scenario7RoundIdToWeatherDicesList);

        scenario1RoundIdToWeatherDicesList.put(1, new ArrayList<>());
        scenario1RoundIdToWeatherDicesList.put(2, new ArrayList<>());
        scenario1RoundIdToWeatherDicesList.put(3, new ArrayList<>());
        scenario1RoundIdToWeatherDicesList.put(4, new ArrayList<>(Collections.singletonList(RAIN_CLOUD_DICE)));
        scenario1RoundIdToWeatherDicesList.put(5, new ArrayList<>(Collections.singletonList(RAIN_CLOUD_DICE)));
        scenario1RoundIdToWeatherDicesList.put(6, new ArrayList<>(Collections.singletonList(RAIN_CLOUD_DICE)));
        scenario1RoundIdToWeatherDicesList.put(7, new ArrayList<>(Arrays.asList(RAIN_CLOUD_DICE, SNOW_CLOUD_DICE, HUNGRY_ANIMALS_DICE)));
        scenario1RoundIdToWeatherDicesList.put(8, new ArrayList<>(Arrays.asList(RAIN_CLOUD_DICE, SNOW_CLOUD_DICE, HUNGRY_ANIMALS_DICE)));
        scenario1RoundIdToWeatherDicesList.put(9, new ArrayList<>(Arrays.asList(RAIN_CLOUD_DICE, SNOW_CLOUD_DICE, HUNGRY_ANIMALS_DICE)));
        scenario1RoundIdToWeatherDicesList.put(10, new ArrayList<>(Arrays.asList(RAIN_CLOUD_DICE, SNOW_CLOUD_DICE, HUNGRY_ANIMALS_DICE)));
        scenario1RoundIdToWeatherDicesList.put(11, new ArrayList<>(Arrays.asList(RAIN_CLOUD_DICE, SNOW_CLOUD_DICE, HUNGRY_ANIMALS_DICE)));
        scenario1RoundIdToWeatherDicesList.put(12, new ArrayList<>(Arrays.asList(RAIN_CLOUD_DICE, SNOW_CLOUD_DICE, HUNGRY_ANIMALS_DICE)));

        scenarioIdToInventionMapping.put(1, new ArrayList<>(Arrays.asList(HATCHET, MAST)));
        scenarioIdToInventionMapping.put(2, new ArrayList<>(Arrays.asList(SACRED_BELL, CROSS)));
        scenarioIdToInventionMapping.put(3, new ArrayList<>(Arrays.asList(JENNY_RAFT, LIFEBOAT)));
        scenarioIdToInventionMapping.put(4, new ArrayList<>(Arrays.asList(null, null)));
        scenarioIdToInventionMapping.put(5, new ArrayList<>(Arrays.asList(BALLISTA, CANOE)));
        scenarioIdToInventionMapping.put(6, new ArrayList<>(Arrays.asList(GARDEN, null)));
        scenarioIdToInventionMapping.put(7, new ArrayList<>(Arrays.asList(TRAP, TRANSQUELEZER)));

        inventionToIsMandatoryMapping.put(BOW, true);
        inventionToIsMandatoryMapping.put(BRICKS, true);
        inventionToIsMandatoryMapping.put(DAM, true);
        inventionToIsMandatoryMapping.put(InventionType.FIRE, true);
        inventionToIsMandatoryMapping.put(KNIFE, true);
        inventionToIsMandatoryMapping.put(MAP, true);
        inventionToIsMandatoryMapping.put(POT, true);
        inventionToIsMandatoryMapping.put(ROPE, true);
        inventionToIsMandatoryMapping.put(SHOVEL, true);
        inventionToIsMandatoryMapping.put(BASKET, false);
        inventionToIsMandatoryMapping.put(BED, false);
        inventionToIsMandatoryMapping.put(BELTS, false);
        inventionToIsMandatoryMapping.put(CELLAR, false);
        inventionToIsMandatoryMapping.put(CORRAL, false);
        inventionToIsMandatoryMapping.put(CURE, false);
        inventionToIsMandatoryMapping.put(DIARY, false);
        inventionToIsMandatoryMapping.put(DRUMS, false);
        inventionToIsMandatoryMapping.put(FIREPLACE, false);
        inventionToIsMandatoryMapping.put(FURNACE, false);
        inventionToIsMandatoryMapping.put(LANTERN, false);
        inventionToIsMandatoryMapping.put(MOAT, false);
        inventionToIsMandatoryMapping.put(PIT, false);
        inventionToIsMandatoryMapping.put(RAFT, false);
        inventionToIsMandatoryMapping.put(SACK, false);
        inventionToIsMandatoryMapping.put(SHIELD, false);
        inventionToIsMandatoryMapping.put(SHORTCUT, false);
        inventionToIsMandatoryMapping.put(SLING, false);
        inventionToIsMandatoryMapping.put(SNARE, false);
        inventionToIsMandatoryMapping.put(SPEAR, false);
        inventionToIsMandatoryMapping.put(WALL, false);

        inventionToOwnerMapping.put(SNARE, CARPENTER);
        inventionToOwnerMapping.put(FIREPLACE, COOK);
        inventionToOwnerMapping.put(SHORTCUT, EXPLORER);
        inventionToOwnerMapping.put(SPEAR, SOLDIER);

        inventionToMultipleInventionMapping.put(BOW, false);
        inventionToMultipleInventionMapping.put(BRICKS, false);
        inventionToMultipleInventionMapping.put(DAM, false);
        inventionToMultipleInventionMapping.put(InventionType.FIRE, false);
        inventionToMultipleInventionMapping.put(KNIFE, false);
        inventionToMultipleInventionMapping.put(MAP, false);
        inventionToMultipleInventionMapping.put(POT, false);
        inventionToMultipleInventionMapping.put(ROPE, false);
        inventionToMultipleInventionMapping.put(SHOVEL, false);
        inventionToMultipleInventionMapping.put(BASKET, false);
        inventionToMultipleInventionMapping.put(BED, false);
        inventionToMultipleInventionMapping.put(BELTS, false);
        inventionToMultipleInventionMapping.put(CELLAR, false);
        inventionToMultipleInventionMapping.put(CORRAL, false);
        inventionToMultipleInventionMapping.put(CURE, false);
        inventionToMultipleInventionMapping.put(DIARY, false);
        inventionToMultipleInventionMapping.put(DRUMS, false);
        inventionToMultipleInventionMapping.put(FIREPLACE, false);
        inventionToMultipleInventionMapping.put(FURNACE, false);
        inventionToMultipleInventionMapping.put(LANTERN, false);
        inventionToMultipleInventionMapping.put(MOAT, false);
        inventionToMultipleInventionMapping.put(PIT, false);
        inventionToMultipleInventionMapping.put(RAFT, false);
        inventionToMultipleInventionMapping.put(SACK, false);
        inventionToMultipleInventionMapping.put(SHIELD, false);
        inventionToMultipleInventionMapping.put(SHORTCUT, false);
        inventionToMultipleInventionMapping.put(SLING, false);
        inventionToMultipleInventionMapping.put(SNARE, false);
        inventionToMultipleInventionMapping.put(SPEAR, false);
        inventionToMultipleInventionMapping.put(WALL, false);
        inventionToMultipleInventionMapping.put(HATCHET, false);
        inventionToMultipleInventionMapping.put(MAST, false);
        inventionToMultipleInventionMapping.put(SACRED_BELL, true);
        inventionToMultipleInventionMapping.put(CROSS, true);
        inventionToMultipleInventionMapping.put(JENNY_RAFT, false);
        inventionToMultipleInventionMapping.put(LIFEBOAT, false);
        inventionToMultipleInventionMapping.put(BALLISTA, false);
        inventionToMultipleInventionMapping.put(CANOE, false);
        inventionToMultipleInventionMapping.put(GARDEN, false);
        inventionToMultipleInventionMapping.put(TRAP, true);
        inventionToMultipleInventionMapping.put(TRANSQUELEZER, false);


        professionToSpecialSkillMapping.put(CARPENTER, new ArrayList<>(Arrays.asList(
                ECONOMICAL_CONSTRUCTION, CRAFT, NEW_IDEA, HANDYMAN)));
        professionToSpecialSkillMapping.put(COOK, new ArrayList<>(Arrays.asList(
                GRANDMAS_RECIPE, SHARP_EYE, NAIL_SOUP, HOOCH)));
        professionToSpecialSkillMapping.put(EXPLORER, new ArrayList<>(Arrays.asList(
                LUCKY_MAN, RECONNAISSANCE, MOTIVATIONAL_SPEECH, SCOUT)));
        professionToSpecialSkillMapping.put(SOLDIER, new ArrayList<>(Arrays.asList(
                TRACKING, HOUNTING, FURY, EMERGENCY_PLAN)));

        professionToPersonalInventionMapping.put(CARPENTER, SNARE);
        professionToPersonalInventionMapping.put(COOK, FIREPLACE);
        professionToPersonalInventionMapping.put(EXPLORER, SHORTCUT);
        professionToPersonalInventionMapping.put(SOLDIER, SPEAR);

        professionToMoraleDownMapping.put(CARPENTER, new ArrayList<>(Arrays.asList(8, 5, 3)));
        professionToMoraleDownMapping.put(COOK, new ArrayList<>(Arrays.asList(9, 6, 4, 2)));
        professionToMoraleDownMapping.put(EXPLORER, new ArrayList<>(Arrays.asList(6, 1)));
        professionToMoraleDownMapping.put(SOLDIER, new ArrayList<>(Arrays.asList(7, 3)));

        professionToLifeMapping.put(CARPENTER, 13);
        professionToLifeMapping.put(COOK, 13);
        professionToLifeMapping.put(EXPLORER, 12);
        professionToLifeMapping.put(SOLDIER, 12);

        professionToMarkerMapping.put(CARPENTER, CARPENTER_MARKER);
        professionToMarkerMapping.put(COOK, COOK_MARKER);
        professionToMarkerMapping.put(EXPLORER, EXPLORER_MARKER);
        professionToMarkerMapping.put(SOLDIER, SOLDIER_MARKER);

        islandTileIdToTerrainMapping.put(1, PLAINS);
        islandTileIdToTerrainMapping.put(2, MOUNTAINS);
        islandTileIdToTerrainMapping.put(3, RIVER);
        islandTileIdToTerrainMapping.put(4, HILLS);
        islandTileIdToTerrainMapping.put(5, MOUNTAINS);
        islandTileIdToTerrainMapping.put(6, PLAINS);
        islandTileIdToTerrainMapping.put(7, HILLS);
        islandTileIdToTerrainMapping.put(8, BEACH);
        islandTileIdToTerrainMapping.put(9, PLAINS);
        islandTileIdToTerrainMapping.put(10, RIVER);
        islandTileIdToTerrainMapping.put(11, MOUNTAINS);

        islandTileIdToLeftSquareResourceMapping.put(1, WOOD);
        islandTileIdToRightSquareResourceMapping.put(1, null);
        islandTileIdToLeftSquareResourceMapping.put(2, FOOD);
        islandTileIdToRightSquareResourceMapping.put(2, null);
        islandTileIdToLeftSquareResourceMapping.put(3, null);
        islandTileIdToRightSquareResourceMapping.put(3, FOOD);
        islandTileIdToLeftSquareResourceMapping.put(4, WOOD);
        islandTileIdToRightSquareResourceMapping.put(4, FOOD);
        islandTileIdToLeftSquareResourceMapping.put(5, FOOD);
        islandTileIdToRightSquareResourceMapping.put(5, WOOD);
        islandTileIdToLeftSquareResourceMapping.put(6, FOOD);
        islandTileIdToRightSquareResourceMapping.put(6, WOOD);
        islandTileIdToLeftSquareResourceMapping.put(7, WOOD);
        islandTileIdToRightSquareResourceMapping.put(7, null);
        islandTileIdToLeftSquareResourceMapping.put(8, WOOD);
        islandTileIdToRightSquareResourceMapping.put(8, FOOD);
        islandTileIdToLeftSquareResourceMapping.put(9, FOOD);
        islandTileIdToRightSquareResourceMapping.put(9, null);
        islandTileIdToLeftSquareResourceMapping.put(10, WOOD);
        islandTileIdToRightSquareResourceMapping.put(10, FOOD);
        islandTileIdToLeftSquareResourceMapping.put(11, WOOD);
        islandTileIdToRightSquareResourceMapping.put(11, null);

        islandTileIdToHasAnimalSourceMapping.put(1, true);
        islandTileIdToHasAnimalSourceMapping.put(2, true);
        islandTileIdToHasAnimalSourceMapping.put(3, true);
        islandTileIdToHasAnimalSourceMapping.put(4, false);
        islandTileIdToHasAnimalSourceMapping.put(5, false);
        islandTileIdToHasAnimalSourceMapping.put(6, false);
        islandTileIdToHasAnimalSourceMapping.put(7, true);
        islandTileIdToHasAnimalSourceMapping.put(8, false);
        islandTileIdToHasAnimalSourceMapping.put(9, true);
        islandTileIdToHasAnimalSourceMapping.put(10, false);
        islandTileIdToHasAnimalSourceMapping.put(11, true);

        islandTileIdToTotemsNumberMapping.put(1, 0);
        islandTileIdToTotemsNumberMapping.put(2, 1);
        islandTileIdToTotemsNumberMapping.put(3, 0);
        islandTileIdToTotemsNumberMapping.put(4, 1);
        islandTileIdToTotemsNumberMapping.put(5, 1);
        islandTileIdToTotemsNumberMapping.put(6, 1);
        islandTileIdToTotemsNumberMapping.put(7, 1);
        islandTileIdToTotemsNumberMapping.put(8, 0);
        islandTileIdToTotemsNumberMapping.put(9, 0);
        islandTileIdToTotemsNumberMapping.put(10, 1);
        islandTileIdToTotemsNumberMapping.put(11, 0);

        islandTileIdToDiscoveryTokensNumberMapping.put(1, 2);
        islandTileIdToDiscoveryTokensNumberMapping.put(2, 1);
        islandTileIdToDiscoveryTokensNumberMapping.put(3, 3);
        islandTileIdToDiscoveryTokensNumberMapping.put(4, 1);
        islandTileIdToDiscoveryTokensNumberMapping.put(5, 1);
        islandTileIdToDiscoveryTokensNumberMapping.put(6, 1);
        islandTileIdToDiscoveryTokensNumberMapping.put(7, 2);
        islandTileIdToDiscoveryTokensNumberMapping.put(8, 0);
        islandTileIdToDiscoveryTokensNumberMapping.put(9, 3);
        islandTileIdToDiscoveryTokensNumberMapping.put(10, 1);
        islandTileIdToDiscoveryTokensNumberMapping.put(11, 1);

        islandTileIdToHasNaturalShelterMapping.put(1, false);
        islandTileIdToHasNaturalShelterMapping.put(2, true);
        islandTileIdToHasNaturalShelterMapping.put(3, false);
        islandTileIdToHasNaturalShelterMapping.put(4, false);
        islandTileIdToHasNaturalShelterMapping.put(5, false);
        islandTileIdToHasNaturalShelterMapping.put(6, false);
        islandTileIdToHasNaturalShelterMapping.put(7, false);
        islandTileIdToHasNaturalShelterMapping.put(8, false);
        islandTileIdToHasNaturalShelterMapping.put(9, false);
        islandTileIdToHasNaturalShelterMapping.put(10, false);
        islandTileIdToHasNaturalShelterMapping.put(11, true);

        currentPhaseToNextPhaseMapping.put(null, EVENT_PHASE);
        currentPhaseToNextPhaseMapping.put(EVENT_PHASE, MORALE_PHASE);
        currentPhaseToNextPhaseMapping.put(MORALE_PHASE, PRODUCTION_PHASE);
        currentPhaseToNextPhaseMapping.put(PRODUCTION_PHASE, ACTION_PHASE);
        currentPhaseToNextPhaseMapping.put(ACTION_PHASE, WEATHER_PHASE);
        currentPhaseToNextPhaseMapping.put(WEATHER_PHASE, NIGHT_PHASE);
        currentPhaseToNextPhaseMapping.put(NIGHT_PHASE, EVENT_PHASE);

    }

    public static Map<InventionType, Boolean> getInventionToMultipleInventionMapping() {
        return inventionToMultipleInventionMapping;
    }

    public static void setInventionToMultipleInventionMapping(Map<InventionType, Boolean> inventionToMultipleInventionMapping) {
        Mappings.inventionToMultipleInventionMapping = inventionToMultipleInventionMapping;
    }

    public static Map<Integer, List<InventionType>> getScenarioIdToInventionMapping() {
        return scenarioIdToInventionMapping;
    }

    public static void setScenarioIdToInventionMapping(Map<Integer, List<InventionType>> scenarioIdToInventionMapping) {
        Mappings.scenarioIdToInventionMapping = scenarioIdToInventionMapping;
    }

    public static Map<ProfessionType, MarkerType> getProfessionToMarkerMapping() {
        return professionToMarkerMapping;
    }

    public static void setProfessionToMarkerMapping(Map<ProfessionType, MarkerType> professionToMarkerMapping) {
        Mappings.professionToMarkerMapping = professionToMarkerMapping;
    }

    public static Map<Integer, Map<Integer, List<DiceType>>> getScenarioIdToRoundWeatherDicesMapMapping() {
        return scenarioIdToRoundWeatherDicesMapMapping;
    }

    public static void setScenarioIdToRoundWeatherDicesMapMapping(Map<Integer, Map<Integer, List<DiceType>>> scenarioIdToRoundWeatherDicesMapMapping) {
        Mappings.scenarioIdToRoundWeatherDicesMapMapping = scenarioIdToRoundWeatherDicesMapMapping;
    }

    public static Map<Integer, List<DiceType>> getScenario1RoundIdToWeatherDicesList() {
        return scenario1RoundIdToWeatherDicesList;
    }

    public static void setScenario1RoundIdToWeatherDicesList(Map<Integer, List<DiceType>> scenario1RoundIdToWeatherDicesList) {
        Mappings.scenario1RoundIdToWeatherDicesList = scenario1RoundIdToWeatherDicesList;
    }

    public static Map<Integer, List<DiceType>> getScenario2RoundIdToWeatherDicesList() {
        return scenario2RoundIdToWeatherDicesList;
    }

    public static void setScenario2RoundIdToWeatherDicesList(Map<Integer, List<DiceType>> scenario2RoundIdToWeatherDicesList) {
        Mappings.scenario2RoundIdToWeatherDicesList = scenario2RoundIdToWeatherDicesList;
    }

    public static Map<Integer, List<DiceType>> getScenario3RoundIdToWeatherDicesList() {
        return scenario3RoundIdToWeatherDicesList;
    }

    public static void setScenario3RoundIdToWeatherDicesList(Map<Integer, List<DiceType>> scenario3RoundIdToWeatherDicesList) {
        Mappings.scenario3RoundIdToWeatherDicesList = scenario3RoundIdToWeatherDicesList;
    }

    public static Map<Integer, List<DiceType>> getScenario4RoundIdToWeatherDicesList() {
        return scenario4RoundIdToWeatherDicesList;
    }

    public static void setScenario4RoundIdToWeatherDicesList(Map<Integer, List<DiceType>> scenario4RoundIdToWeatherDicesList) {
        Mappings.scenario4RoundIdToWeatherDicesList = scenario4RoundIdToWeatherDicesList;
    }

    public static Map<Integer, List<DiceType>> getScenario5RoundIdToWeatherDicesList() {
        return scenario5RoundIdToWeatherDicesList;
    }

    public static void setScenario5RoundIdToWeatherDicesList(Map<Integer, List<DiceType>> scenario5RoundIdToWeatherDicesList) {
        Mappings.scenario5RoundIdToWeatherDicesList = scenario5RoundIdToWeatherDicesList;
    }

    public static Map<Integer, List<DiceType>> getScenario6RoundIdToWeatherDicesList() {
        return scenario6RoundIdToWeatherDicesList;
    }

    public static void setScenario6RoundIdToWeatherDicesList(Map<Integer, List<DiceType>> scenario6RoundIdToWeatherDicesList) {
        Mappings.scenario6RoundIdToWeatherDicesList = scenario6RoundIdToWeatherDicesList;
    }

    public static Map<Integer, List<DiceType>> getScenario7RoundIdToWeatherDicesList() {
        return scenario7RoundIdToWeatherDicesList;
    }

    public static void setScenario7RoundIdToWeatherDicesList(Map<Integer, List<DiceType>> scenario7RoundIdToWeatherDicesList) {
        Mappings.scenario7RoundIdToWeatherDicesList = scenario7RoundIdToWeatherDicesList;
    }

    public static Map<PhaseType, PhaseType> getCurrentPhaseToNextPhaseMapping() {
        return currentPhaseToNextPhaseMapping;
    }

    public static void setCurrentPhaseToNextPhaseMapping(Map<PhaseType, PhaseType> currentPhaseToNextPhaseMapping) {
        Mappings.currentPhaseToNextPhaseMapping = currentPhaseToNextPhaseMapping;
    }

    public static Map<Integer, TerrainType> getIslandTileIdToTerrainMapping() {
        return islandTileIdToTerrainMapping;
    }

    public static void setIslandTileIdToTerrainMapping(Map<Integer, TerrainType> islandTileIdToTerrainMapping) {
        Mappings.islandTileIdToTerrainMapping = islandTileIdToTerrainMapping;
    }

    public static Map<Integer, Boolean> getIslandTileIdToHasAnimalSourceMapping() {
        return islandTileIdToHasAnimalSourceMapping;
    }

    public static void setIslandTileIdToHasAnimalSourceMapping(Map<Integer, Boolean> islandTileIdToHasAnimalSourceMapping) {
        Mappings.islandTileIdToHasAnimalSourceMapping = islandTileIdToHasAnimalSourceMapping;
    }

    public static Map<Integer, Integer> getIslandTileIdToTotemsNumberMapping() {
        return islandTileIdToTotemsNumberMapping;
    }

    public static void setIslandTileIdToTotemsNumberMapping(Map<Integer, Integer> islandTileIdToTotemsNumberMapping) {
        Mappings.islandTileIdToTotemsNumberMapping = islandTileIdToTotemsNumberMapping;
    }

    public static Map<Integer, Integer> getIslandTileIdToDiscoveryTokensNumberMapping() {
        return islandTileIdToDiscoveryTokensNumberMapping;
    }

    public static void setIslandTileIdToDiscoveryTokensNumberMapping(Map<Integer, Integer> islandTileIdToDiscoveryTokensNumberMapping) {
        Mappings.islandTileIdToDiscoveryTokensNumberMapping = islandTileIdToDiscoveryTokensNumberMapping;
    }

    public static Map<Integer, Boolean> getIslandTileIdToHasNaturalShelterMapping() {
        return islandTileIdToHasNaturalShelterMapping;
    }

    public static void setIslandTileIdToHasNaturalShelterMapping(Map<Integer, Boolean> islandTileIdToHasNaturalShelterMapping) {
        Mappings.islandTileIdToHasNaturalShelterMapping = islandTileIdToHasNaturalShelterMapping;
    }

    public static Map<Integer, ResourceType> getIslandTileIdToLeftSquareResourceMapping() {
        return islandTileIdToLeftSquareResourceMapping;
    }

    public static void setIslandTileIdToLeftSquareResourceMapping(Map<Integer, ResourceType> islandTileIdToLeftSquareResourceMapping) {
        Mappings.islandTileIdToLeftSquareResourceMapping = islandTileIdToLeftSquareResourceMapping;
    }

    public static Map<Integer, ResourceType> getIslandTileIdToRightSquareResourceMapping() {
        return islandTileIdToRightSquareResourceMapping;
    }

    public static void setIslandTileIdToRightSquareResourceMapping(Map<Integer, ResourceType> islandTileIdToRightSquareResourceMapping) {
        Mappings.islandTileIdToRightSquareResourceMapping = islandTileIdToRightSquareResourceMapping;
    }

    public static Map<ProfessionType, InventionType> getProfessionToPersonalInventionMapping() {
        return professionToPersonalInventionMapping;
    }

    public static void setProfessionToPersonalInventionMapping(Map<ProfessionType, InventionType> professionToPersonalInventionMapping) {
        Mappings.professionToPersonalInventionMapping = professionToPersonalInventionMapping;
    }

    public static Map<ProfessionType, Integer> getProfessionToLifeMapping() {
        return professionToLifeMapping;
    }

    public static void setProfessionToLifeMapping(Map<ProfessionType, Integer> professionToLifeMapping) {
        Mappings.professionToLifeMapping = professionToLifeMapping;
    }

    public static Map<ProfessionType, List<Integer>> getProfessionToMoraleDownMapping() {
        return professionToMoraleDownMapping;
    }

    public static void setProfessionToMoraleDownMapping(Map<ProfessionType, List<Integer>> professionToMoraleDownMapping) {
        Mappings.professionToMoraleDownMapping = professionToMoraleDownMapping;
    }

    public static Map<InventionType, ProfessionType> getInventionToOwnerMapping() {
        return inventionToOwnerMapping;
    }

    public static void setInventionToOwnerMapping(Map<InventionType, ProfessionType> inventionToOwnerMapping) {
        Mappings.inventionToOwnerMapping = inventionToOwnerMapping;
    }

    public static Map<ProfessionType, List<SpecialSkillType>> getProfessionToSpecialSkillMapping() {
        return professionToSpecialSkillMapping;
    }

    public static void setProfessionToSpecialSkillMapping(Map<ProfessionType, List<SpecialSkillType>> professionToSpecialSkillMapping) {
        Mappings.professionToSpecialSkillMapping = professionToSpecialSkillMapping;
    }

    public static Map<InventionType, Boolean> getInventionToIsMandatoryMapping() {
        return inventionToIsMandatoryMapping;
    }

    public static void setInventionToIsMandatoryMapping(Map<InventionType, Boolean> inventionToIsMandatoryMapping) {
        Mappings.inventionToIsMandatoryMapping = inventionToIsMandatoryMapping;
    }

    public static Map<Integer, Integer> getScenarioIdToRoundsNumberMapping() {
        return scenarioIdToRoundsNumberMapping;
    }

    public static void setScenarioIdToRoundsNumberMapping(Map<Integer, Integer> scenarioIdToRoundsNumberMapping) {
        Mappings.scenarioIdToRoundsNumberMapping = scenarioIdToRoundsNumberMapping;
    }

    public static Map<EventEffectType, EventIconType> getEventEffectToEventIconMapping() {
        return eventEffectToEventIconMapping;
    }

    public static void setEventEffectToEventIconMapping(Map<EventEffectType, EventIconType> eventEffectToEventIconMapping) {
        Mappings.eventEffectToEventIconMapping = eventEffectToEventIconMapping;
    }

    public static Map<EventEffectType, ThreatActionType> getEventEffectToThreatActionMapping() {
        return eventEffectToThreatActionMapping;
    }

    public static void setEventEffectToThreatActionMapping(Map<EventEffectType, ThreatActionType> eventEffectToThreatActionMapping) {
        Mappings.eventEffectToThreatActionMapping = eventEffectToThreatActionMapping;
    }

    public static Map<EventEffectType, ThreatEffectType> getEventEffectToThreatEffectMapping() {
        return eventEffectToThreatEffectMapping;
    }

    public static void setEventEffectToThreatEffectMapping(Map<EventEffectType, ThreatEffectType> eventEffectToThreatEffectMapping) {
        Mappings.eventEffectToThreatEffectMapping = eventEffectToThreatEffectMapping;
    }

    public static Map<BuildingAdventureType, AdventureEventEffectType> getBuildingAdvntureToAdventureEventEffectMapping() {
        return buildingAdvntureToAdventureEventEffectMapping;
    }

    public static void setBuildingAdvntureToAdventureEventEffectMapping(Map<BuildingAdventureType, AdventureEventEffectType> buildingAdvntureToAdventureEventEffectMapping) {
        Mappings.buildingAdvntureToAdventureEventEffectMapping = buildingAdvntureToAdventureEventEffectMapping;
    }

    public static Map<GatheringResourcesAdventureType, AdventureEventEffectType> getGatheringAdventureToAdventureEventEffectMapping() {
        return gatheringAdventureToAdventureEventEffectMapping;
    }

    public static void setGatheringAdventureToAdventureEventEffectMapping(Map<GatheringResourcesAdventureType, AdventureEventEffectType> gatheringAdventureToAdventureEventEffectMapping) {
        Mappings.gatheringAdventureToAdventureEventEffectMapping = gatheringAdventureToAdventureEventEffectMapping;
    }

    public static Map<ExplorationAdventureType, AdventureEventEffectType> getExplorationAdventureToAdventureEventEffectMapping() {
        return explorationAdventureToAdventureEventEffectMapping;
    }

    public static void setExplorationAdventureToAdventureEventEffectMapping(Map<ExplorationAdventureType, AdventureEventEffectType> explorationAdventureToAdventureEventEffectMapping) {
        Mappings.explorationAdventureToAdventureEventEffectMapping = explorationAdventureToAdventureEventEffectMapping;
    }

    public static Map<BeastType, List<Integer>> getBeastToBeastStatsMapping() {
        return beastToBeastStatsMapping;
    }

    public static void setBeastToBeastStatsMapping(Map<BeastType, List<Integer>> beastToBeastStatsMapping) {
        Mappings.beastToBeastStatsMapping = beastToBeastStatsMapping;
    }
}
