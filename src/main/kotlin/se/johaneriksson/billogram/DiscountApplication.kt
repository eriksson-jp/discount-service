package se.johaneriksson.billogram

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DiscountApplication

fun main(args: Array<String>) {
	runApplication<DiscountApplication>(*args)
}
