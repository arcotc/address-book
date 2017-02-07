package addressbook

import org.joda.time.{LocalDate, Years}

case class AddressEntry(foreName: String, surname: String, gender: String, dob: LocalDate) {
  def age: Int = {
    Years.yearsBetween(dob, LocalDate.now).getYears
  }
}
