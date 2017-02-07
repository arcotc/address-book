package addressbook

import org.scalatest.FunSuite

class AddressBookTest extends FunSuite {
  val expectedMalesCount = 3
  val expectedFemalesCount = 2

  test("Load address book from file") {
    assert(AddressBook.readFile.size == expectedMalesCount + expectedFemalesCount)
  }

  test("Count males in file") {
    assert(AddressBook.entriesByGender(AddressBook.readFile, Gender.MALE).size == expectedMalesCount)
  }

  test("Count females in file") {
    assert(AddressBook.entriesByGender(AddressBook.readFile, Gender.FEMALE).size == expectedFemalesCount)
  }

  test("Oldest member in file") {
    assert(AddressBook.oldest(AddressBook.readFile).fullName == "Wes Jackson")
  }

  test("Youngest member in file") {
    assert(AddressBook.youngest(AddressBook.readFile).fullName == "Gemma Lane")
  }
}
