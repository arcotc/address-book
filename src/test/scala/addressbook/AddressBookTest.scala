package addressbook

import org.scalatest.FunSuite

class AddressBookTest extends FunSuite {
  test("Load address book from file") {
    assert(AddressBook.readFile.size == 5)
  }
}
