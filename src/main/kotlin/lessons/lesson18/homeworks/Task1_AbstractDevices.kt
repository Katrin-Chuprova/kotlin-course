package lessons.lesson18.homeworks

// ===== ЗАДАНИЕ 1. Абстрактные классы устройств (только интерфейсы, без реализаций) =====

abstract class AbstractFridge :
    Powerable, Openable, TemperatureRegulatable, Cleanable, LightEmitting

abstract class AbstractWashingMachine :
    Powerable, Openable, TemperatureRegulatable, Programmable,
    WaterConnection, Drainable, Timable, Cleanable, SoundEmitting

abstract class AbstractSmartLamp :
    Powerable, LightEmitting, Timable, Programmable

abstract class AbstractElectronicClock :
    Powerable, Timable, LightEmitting, BatteryOperated

abstract class AbstractRobotVacuum :
    Powerable, Programmable, Movable, Cleanable, Rechargeable, AutomaticShutdown

abstract class AbstractMechanicalClock :
    Mechanical, Timable

abstract class AbstractFlashlight :
    Powerable, LightEmitting, BatteryOperated, Rechargeable

abstract class AbstractCoffeeMachine :
    Powerable, Openable, TemperatureRegulatable, WaterContainer, WaterConnection, Programmable, Cleanable

abstract class AbstractSmartSpeaker :
    Powerable, Programmable, SoundEmitting, Timable
