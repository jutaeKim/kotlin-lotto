package lotto.model.data

class Policy645 : Policy {
    override val rangeOfNumbers = 1..45
    override val countOfNumberToSelect = 6
    override val priceOfLotto = 1_000
    override val limitAmountToPurchase = 100_000

    override fun validateNumbers(numbers: Collection<Int>) {
        super.validateNumbers(numbers.distinct()) // 번호 중복 불가
    }
}
