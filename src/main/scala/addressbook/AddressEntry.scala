package addressbook

import org.joda.time.{Days, LocalDate, Years}

case class AddressEntry(foreName: String, surname: String, gender: String, dob: LocalDate) {
  val MALE = "male"
  val FEMALE = "female"

  def age: Int = {
    Years.yearsBetween(dob, LocalDate.now).getYears
  }

  def isOlder(entryToCompareTo: AddressEntry): Boolean = {
    Days.daysBetween(dob, entryToCompareTo.dob).getDays > 0
  }

  def isMale: Boolean = gender.toLowerCase == MALE

  def isFemale: Boolean = gender.toLowerCase == FEMALE
}
