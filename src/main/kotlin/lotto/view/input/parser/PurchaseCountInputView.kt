package lotto.view.input.parser

import lotto.model.data.Policy
import lotto.view.input.ConsoleReader
import lotto.view.input.InputView

class PurchaseCountInputView(
    private val policy: Policy,
    moneyAmountProvider: (() -> Int)? = null
) : InputView<Int> {

    private val inputParser = IntInputParser(1000..Int.MAX_VALUE)
    private val readInputAction = moneyAmountProvider ?: this::readAmountFromConsole

    override fun getInput(): Int {
        val purchaseAmount = readInputAction()
        val numberOfLotto = purchaseAmount / policy.priceOfLotto
        println("${numberOfLotto}개를 구매했습니다.")
        return numberOfLotto
    }

    private fun readAmountFromConsole(): Int {
        return ConsoleReader.read(MESSAGE_TO_PURCHASE, inputParser)
    }

    companion object {
        private const val MESSAGE_TO_PURCHASE = "구입금액을 입력해 주세요."
    }
}
