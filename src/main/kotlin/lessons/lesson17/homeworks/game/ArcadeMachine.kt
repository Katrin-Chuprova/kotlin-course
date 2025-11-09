package lessons.lesson17.homeworks.game

/**
 * Схематический класс игрового автомата.
 * Поля подобраны с учётом инкапсуляции: что-то доступно только на чтение, что-то скрыто (private).
 */
class ArcadeMachine(
    // Постоянные характеристики автомата
    val color: String,                   // цвет
    val model: String,                   // модель
    val owner: String,                   // владелец
    val supportPhone: String,            // телефон поддержки
    sessionCost: Int,                    // стоимость одного игрового сеанса
    hasJoystickInitial: Boolean,         // наличие джойстика при установке
    pinCode: String,                     // пин-код автомата
    installedGames: List<Game> = emptyList() // стартовый набор игр
) {
    // Текущее состояние
    var isPoweredOn: Boolean = false         // включен
        private set
    var isOsLoaded: Boolean = false          // ОС загружена
        private set
    var hasJoystick: Boolean = hasJoystickInitial // наличие джойстика
        private set
    var isSessionPaid: Boolean = false       // игровой сеанс оплачен
        private set

    // Экономика
    val sessionPrice: Int = sessionCost      // стоимость одного игрового сеанса (константа для экземпляра)
    private var cashBalance: Long = 0L       // баланс вырученных средств (в условных единицах/копейках)

    // Игры: наружу выдаём только read-only представление
    private val _installedGames = installedGames.toMutableList()
    val games: List<Game> get() = _installedGames

    // Безопасность
    private var pin: String = pinCode        // пин-код автомата (скрыт)

    /* ================= Методы управления питанием и ОС ================= */

    /** Включить автомат. Возвращает текущее состояние (включен ли). */
    fun powerOn(): Boolean {
        isPoweredOn = true
        return isPoweredOn
    }

    /** Выключить автомат (ОС выгружается). Возвращает текущее состояние (включен ли). */
    fun powerOff(): Boolean {
        isOsLoaded = false
        isPoweredOn = false
        return isPoweredOn
    }

    /** Загрузить ОС. Возвращает true, если операция успешна. */
    fun bootOs(): Boolean {
        if (!isPoweredOn) return false
        isOsLoaded = true
        return true
    }

    /** Завершить работу ОС. Возвращает true, если операция успешна. */
    fun shutdownOs(): Boolean {
        if (!isPoweredOn) return false
        isOsLoaded = false
        return true
    }

    /* ================= Работа с играми и сеансом ================= */

    /** Показать список игр (названия). */
    fun showGames(): List<String> = games.map { it.title }

    /**
     * Включить игру по названию.
     * Успех возможен только если автомат включён, ОС загружена и сеанс оплачен.
     */
    fun startGame(title: String): Boolean {
        val canRun = isPoweredOn && isOsLoaded && isSessionPaid
        val exists = games.any { it.title.equals(title, ignoreCase = true) }
        return canRun && exists
    }

    /**
     * Оплатить игровой сеанс. Возвращает true, если внесённой суммы достаточно.
     * Сумма — целая, для простоты (можно заменить на Long/BigDecimal).
     */
    fun payForSession(amount: Int): Boolean {
        if (amount < sessionPrice) return false
        cashBalance += amount
        isSessionPaid = true
        return true
    }

    /* ================= Инкассация ================= */

    /**
     * Забрать наличные, введя пин-код.
     * Возвращает сумму, если пин верный, иначе — null.
     */
    fun collectCash(enteredPin: String): Long? {
        if (enteredPin != pin) return null
        return openSafeAndDispenseCash()
    }

    /**
     * Открыть сейф и выдать наличные.
     * Приватный метод — его нельзя вызвать извне, только через проверенный публичный сценарий.
     */
    private fun openSafeAndDispenseCash(): Long {
        val amount = cashBalance
        cashBalance = 0L
        isSessionPaid = false // сброс оплаченного сеанса после инкассации (по политике можно изменить)
        return amount
    }

    /* ================= Дополнительно (по желанию расширения) ================= */

    /** Установить новую игру. */
    fun installGame(game: Game): Boolean = _installedGames.add(game)

    /** Подключить/отключить джойстик изнутри (например, сервисный режим). */
    fun setJoystickConnected(connected: Boolean) {
        hasJoystick = connected
    }
}