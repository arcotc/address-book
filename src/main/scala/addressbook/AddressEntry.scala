package addressbook

import org.joda.time.{Days, LocalDate, Years}

case class AddressEntry(foreName: String, surname: String, gender: String, dob: LocalDate) {
  def fullName = s"$foreName $surname"

  def age: Int = {
    Years.yearsBetween(dob, LocalDate.now).getYears
  }

  def isOlder(entryToCompareTo: AddressEntry): Boolean = {
    Days.daysBetween(dob, entryToCompareTo.dob).getDays > 0
  }

  def isMale: Boolean = gender.toLowerCase == Gender.MALE

  def isFemale: Boolean = gender.toLowerCase == Gender.FEMALE

  def daysOlder(entryToCompareTo: AddressEntry): Int = {
    val numberOfDaysBetween = Days.daysBetween(dob, entryToCompareTo.dob).getDays
    numberOfDaysBetween > 0 match {
      case true => numberOfDaysBetween
      case _ => numberOfDaysBetween * -1
    }
  }
}
