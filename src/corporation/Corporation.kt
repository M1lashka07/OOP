package corporation

fun main() {

    WorkersRepository.workers.forEach { it.work() }

}