package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val people = listOf(
            Person("박재성", 29, "제이슨"),
            Person("박재성", 29, nickname = "제이슨"),
            Person(name = "박재성", age = 29, nickname = "제이슨")
        )
        assertThat(people[0].name).isEqualTo("박재성")
        assertThat(people[1].name).isEqualTo("박재성")
        assertThat(people[2].name).isEqualTo("박재성")
    }

    @Test
    fun `널 타입`() {
        val person = Person("박재성", 29, null)
        assertThat(person.name).isEqualTo("박재성")
        assertThat(person.age).isEqualTo(29)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("박재성", 29)
        assertThat(person.name).isEqualTo("박재성")
        assertThat(person.age).isEqualTo(29)
        assertThat(person.nickname).isEqualTo("박재성")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("박재성", 29)
        val person2 = Person("박재성", 29)
        assertThat(person1).isEqualTo(person2)
    }
}