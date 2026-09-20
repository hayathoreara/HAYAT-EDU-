package com.example.data.repository

data class TrigValueRow(
    val angleDeg: String,
    val angleRad: String,
    val sinVal: String,
    val cosVal: String,
    val tanVal: String,
    val cotVal: String,
    val secVal: String,
    val cscVal: String
)

data class TrigIdentityGroup(
    val category: String,
    val formulas: List<Pair<String, String>>
)

object TrigonometryData {
    val tableValues = listOf(
        TrigValueRow("0°", "0", "0", "1", "0", "Not Defined (∞)", "1", "Not Defined (∞)"),
        TrigValueRow("30°", "π/6", "1/2", "√3/2", "1/√3", "√3", "2/√3", "2"),
        TrigValueRow("45°", "π/4", "1/√2", "1/√2", "1", "1", "√2", "√2"),
        TrigValueRow("60°", "π/3", "√3/2", "1/2", "√3", "1/√3", "2", "2/√3"),
        TrigValueRow("90°", "π/2", "1", "0", "Not Defined (∞)", "0", "Not Defined (∞)", "1"),
        TrigValueRow("120°", "2π/3", "√3/2", "-1/2", "-√3", "-1/√3", "-2", "2/√3"),
        TrigValueRow("135°", "3π/4", "1/√2", "-1/√2", "-1", "-1", "-√2", "√2"),
        TrigValueRow("150°", "5π/6", "1/2", "-√3/2", "-1/√3", "-√3", "-2/√3", "2"),
        TrigValueRow("180°", "π", "0", "-1", "0", "Not Defined (∞)", "-1", "Not Defined (∞)"),
        TrigValueRow("270°", "3π/2", "-1", "0", "Not Defined (∞)", "0", "Not Defined (∞)", "-1"),
        TrigValueRow("360°", "2π", "0", "1", "0", "Not Defined (∞)", "1", "Not Defined (∞)")
    )

    val identityGroups = listOf(
        TrigIdentityGroup(
            "1. Fundamental & Pythagorean Identities",
            listOf(
                "sin²θ + cos²θ = 1" to "cos²θ = 1 - sin²θ  |  sin²θ = 1 - cos²θ",
                "1 + tan²θ = sec²θ" to "sec²θ - tan²θ = 1  |  tan²θ = sec²θ - 1",
                "1 + cot²θ = cosec²θ" to "cosec²θ - cot²θ = 1  |  cot²θ = cosec²θ - 1",
                "tan θ = sin θ / cos θ" to "cot θ = cos θ / sin θ",
                "sec θ = 1 / cos θ" to "cosec θ = 1 / sin θ"
            )
        ),
        TrigIdentityGroup(
            "2. Negative Angle & Periodic Identities",
            listOf(
                "sin(-θ) = -sin θ" to "cos(-θ) = cos θ (Even Function)",
                "tan(-θ) = -tan θ" to "cot(-θ) = -cot θ",
                "sec(-θ) = sec θ" to "cosec(-θ) = -cosec θ",
                "sin(2nπ + θ) = sin θ" to "cos(2nπ + θ) = cos θ (Period 2π)",
                "tan(nπ + θ) = tan θ" to "cot(nπ + θ) = cot θ (Period π)"
            )
        ),
        TrigIdentityGroup(
            "3. Compound Angle Formulas (Sum & Difference)",
            listOf(
                "sin(A + B) = sin A cos B + cos A sin B" to "Addition identity for sine",
                "sin(A - B) = sin A cos B - cos A sin B" to "Subtraction identity for sine",
                "cos(A + B) = cos A cos B - sin A sin B" to "Addition identity for cosine",
                "cos(A - B) = cos A cos B + sin A sin B" to "Subtraction identity for cosine",
                "tan(A + B) = (tan A + tan B) / (1 - tan A tan B)" to "For tan sum",
                "tan(A - B) = (tan A - tan B) / (1 + tan A tan B)" to "For tan difference"
            )
        ),
        TrigIdentityGroup(
            "4. Double & Triple Angle Formulas",
            listOf(
                "sin 2A = 2 sin A cos A" to "In tan terms: 2 tan A / (1 + tan² A)",
                "cos 2A = cos² A - sin² A" to "Also: 2cos² A - 1 = 1 - 2sin² A = (1 - tan² A) / (1 + tan² A)",
                "tan 2A = 2 tan A / (1 - tan² A)" to "Double angle for tangent",
                "sin 3A = 3 sin A - 4 sin³ A" to "Triple angle for sine",
                "cos 3A = 4 cos³ A - 3 cos A" to "Triple angle for cosine",
                "tan 3A = (3 tan A - tan³ A) / (1 - 3 tan² A)" to "Triple angle for tangent"
            )
        ),
        TrigIdentityGroup(
            "5. Product to Sum & Sum to Product Transformation",
            listOf(
                "2 sin A cos B = sin(A + B) + sin(A - B)" to "Product of sin and cos",
                "2 cos A sin B = sin(A + B) - sin(A - B)" to "Product of cos and sin",
                "2 cos A cos B = cos(A + B) + cos(A - B)" to "Product of two cosines",
                "2 sin A sin B = cos(A - B) - cos(A + B)" to "Product of two sines",
                "sin C + sin D = 2 sin((C+D)/2) cos((C-D)/2)" to "Sum of two sines",
                "sin C - sin D = 2 cos((C+D)/2) sin((C-D)/2)" to "Difference of two sines",
                "cos C + cos D = 2 cos((C+D)/2) cos((C-D)/2)" to "Sum of two cosines",
                "cos C - cos D = -2 sin((C+D)/2) sin((C-D)/2)" to "= 2 sin((C+D)/2) sin((D-C)/2)"
            )
        )
    )
}
