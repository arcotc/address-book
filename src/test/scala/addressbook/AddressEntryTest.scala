package addressbook

import org.joda.time.LocalDate
import org.scalatest.FunSuite

class AddressEntryTest extends FunSuite {
  val entry1 = new AddressEntry("Sammy", "Davis", "Male", LocalDate.now.minusYears(60))
  val entry2 = new AddressEntry("Martha", "Hamilton", "Female", LocalDate.now.minusYears(45))

  test("Entrants age") {
    assert(entry1.age == 60)
    assert(entry2.age == 45)
  }

  test("Entry is older than another entry") {
    assert(entry1.isOlder(entry2))
  }

  test("Entry is younger than another entry") {
    assert(!entry2.isOlder(entry1))
  }
}
