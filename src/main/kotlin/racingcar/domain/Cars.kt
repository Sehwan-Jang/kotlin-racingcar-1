package racingcar.domain

class Cars(private val cars: ArrayList<Car>) {

    constructor(carNum: Int) : this(ArrayList()) {
        createList(carNum)
    }

    private fun createList(carNum: Int) {
        for (i in 0 until carNum) {
            cars.add(Car(RandomMoveStrategy))
        }
    }


    fun cars(): List<Car> {
        return cars.toList()
    }

    fun race() {
        cars.stream()
            .forEach { car -> car.move() }

    }

    fun status(): LinkedHashMap<String, Int> {
        val status = LinkedHashMap<String, Int>()

        for (car in cars) {
            status[car.name] = car.position
        }

        return status
    }

    fun winners(): List<String> {
        val winningPosition: Int = cars
            .map { car -> car.position }
            .max()!!
        return cars.filter { car -> car.isSamePosition(winningPosition) }
            .map { car -> car.name }
            .toList()
    }

}