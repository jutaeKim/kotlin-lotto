package lotto.model.data

import lotto.util.toBlankRemovedIntList

data class Lotto private constructor(val numbers: Set<Int>) {

    companion object {
        fun Collection<Int>.toLotto(policy: Policy): Lotto {
            policy.validateNumbers(this)
            return Lotto(this.sorted().toSet())
        }

        fun String.toLotto(policy: Policy): Lotto {
            val numbers = this.toBlankRemovedIntList()
            return numbers.toLotto(policy)
        }
    }
}

data class Lottos(val lottoList: List<Lotto>) : List<Lotto> by lottoList {
    companion object {
        fun of(vararg lottos: Lotto) = Lottos(lottos.toList())
    }
}

inline fun Lottos(count: Int = 1, init: (Int) -> Lotto) = Lottos(List(count, init))
