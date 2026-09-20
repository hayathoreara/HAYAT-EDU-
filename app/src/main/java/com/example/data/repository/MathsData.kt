package com.example.data.repository

import com.example.data.model.*

object MathsData {
    val chapters: List<Chapter> = listOf(
        Chapter(
            id = "math_ch1",
            number = 1,
            subject = SubjectType.MATHEMATICS,
            title = "Sets",
            overview = "A set is a well-defined collection of distinct objects. Introduced by German mathematician Georg Cantor, set theory is foundational to modern mathematics.",
            keyPoints = listOf(
                "A set is represented in Roster (Tabular) form or Set-Builder form.",
                "Empty set (Null set) ∅ contains no elements.",
                "Subset: A ⊆ B if every element of A is also in B. Number of subsets of set with n elements is 2ⁿ.",
                "Power Set P(A) is the set of all subsets of A.",
                "Universal Set (U) contains all objects under consideration."
            ),
            formulas = listOf(
                FormulaItem("Subsets of Finite Set", "n(P(A)) = 2ⁿ", "Total number of subsets for a set with n elements"),
                FormulaItem("Union of Two Sets", "n(A ∪ B) = n(A) + n(B) - n(A ∩ B)", "Inclusion-exclusion principle for 2 sets"),
                FormulaItem("Union of Three Sets", "n(A ∪ B ∪ C) = n(A) + n(B) + n(C) - n(A∩B) - n(B∩C) - n(A∩C) + n(A∩B∩C)", "For 3 sets"),
                FormulaItem("De Morgan's Laws", "(A ∪ B)' = A' ∩ B' and (A ∩ B)' = A' ∪ B'", "Complement properties")
            ),
            definitions = listOf(
                "Set" to "A well-defined collection of distinct objects.",
                "Empty Set" to "A set containing no elements, denoted by ∅ or {}.",
                "Disjoint Sets" to "Two sets A and B are disjoint if A ∩ B = ∅."
            ),
            examples = listOf(
                SolvedExample(
                    question = "If A and B are two sets such that n(A) = 17, n(B) = 23, and n(A ∪ B) = 38, find n(A ∩ B).",
                    solution = "Formula: n(A ∪ B) = n(A) + n(B) - n(A ∩ B)\n38 = 17 + 23 - n(A ∩ B)\n38 = 40 - n(A ∩ B)\nn(A ∩ B) = 40 - 38 = 2.",
                    keyStep = "Apply inclusion-exclusion formula directly."
                )
            ),
            practiceQuestions = listOf(
                PracticeQuestion("Write the set {x : x is an integer and -3 < x < 7} in roster form.", "List integers strictly between -3 and 7", "{-2, -1, 0, 1, 2, 3, 4, 5, 6}"),
                PracticeQuestion("How many elements has P(A), if A = ∅?", "n(A) = 0", "2⁰ = 1 element (the empty set itself)")
            ),
            mcqs = listOf(
                McqQuestion("m1_1", "If set A has 4 elements, how many subsets does it possess?", listOf("8", "16", "32", "64"), 1, "Number of subsets is 2⁴ = 16.", "Sets", SubjectType.MATHEMATICS),
                McqQuestion("m1_2", "Which of the following is equivalent to (A ∪ B)' according to De Morgan's law?", listOf("A' ∪ B'", "A' ∩ B'", "A ∩ B", "A' ∪ B"), 1, "De Morgan's law states (A ∪ B)' = A' ∩ B'.", "Sets", SubjectType.MATHEMATICS)
            ),
            quickRevision = listOf(
                "∅ is a subset of every set.",
                "Every set is a subset of itself: A ⊆ A.",
                "A - B = A ∩ B' (elements in A but not in B)."
            )
        ),
        Chapter(
            id = "math_ch2",
            number = 2,
            subject = SubjectType.MATHEMATICS,
            title = "Relations and Functions",
            overview = "Cartesian product of sets, definition of relation, domain, co-domain and range. Definition of function as a special kind of relation.",
            keyPoints = listOf(
                "Cartesian Product A × B = {(a, b) : a ∈ A, b ∈ B}. n(A × B) = n(A) × n(B).",
                "A relation R from A to B is a subset of A × B.",
                "Total number of relations from A to B is 2^(p·q) where p = n(A), q = n(B).",
                "A function f: A → B maps each element in A to a unique element in B."
            ),
            formulas = listOf(
                FormulaItem("Total Relations", "N = 2^(n(A) × n(B))", "Number of distinct relations possible"),
                FormulaItem("Modulus Function", "f(x) = |x| = { x if x ≥ 0; -x if x < 0 }", "Domain = R, Range = [0, ∞)"),
                FormulaItem("Signum Function", "f(x) = 1 (x > 0), 0 (x = 0), -1 (x < 0)", "Domain = R, Range = {-1, 0, 1}")
            ),
            definitions = listOf(
                "Relation" to "A subset of the Cartesian product A × B.",
                "Function" to "A relation f from A to B such that every element of A has one and only one image in B."
            ),
            examples = listOf(
                SolvedExample(
                    question = "Let A = {1, 2} and B = {3, 4}. Find the number of relations from A to B.",
                    solution = "n(A) = 2, n(B) = 2.\nn(A × B) = 2 × 2 = 4.\nTotal relations = 2⁴ = 16.",
                    keyStep = "Use formula 2^(p·q)."
                )
            ),
            practiceQuestions = listOf(
                PracticeQuestion("Find the domain of f(x) = √(9 - x²).", "Value under square root must be non-negative: 9 - x² ≥ 0", "Domain = [-3, 3]")
            ),
            mcqs = listOf(
                McqQuestion("m2_1", "What is the range of the signum function?", listOf("R", "[-1, 1]", "{-1, 0, 1}", "[0, ∞)"), 2, "Signum function takes only 3 discrete values: -1, 0, and 1.", "Relations and Functions", SubjectType.MATHEMATICS)
            ),
            quickRevision = listOf(
                "Domain is the set of all first coordinates in a relation/function.",
                "Range is the set of all second coordinates that are images.",
                "Co-domain is the entire target set B."
            )
        ),
        Chapter(
            id = "math_ch3",
            number = 3,
            subject = SubjectType.MATHEMATICS,
            title = "Trigonometric Functions",
            overview = "Angles in radians and degrees, trigonometric ratios and functions, signs in quadrants, compound angle formulas, multiple angles, and trigonometric equations.",
            keyPoints = listOf(
                "Radian measure: π radians = 180°. θ = l / r where l is arc length, r is radius.",
                "Sign convention (ASTC rule): Q1 (All +), Q2 (Sin, Csc +), Q3 (Tan, Cot +), Q4 (Cos, Sec +).",
                "Periodic behavior: sin and cos have period 2π; tan and cot have period π."
            ),
            formulas = listOf(
                FormulaItem("Degree to Radian", "Radian = Degree × (π / 180)", "Conversion rule"),
                FormulaItem("Arc Length", "l = r · θ", "θ must be in radians"),
                FormulaItem("Pythagorean Identity", "sin²θ + cos²θ = 1", "Fundamental relationship"),
                FormulaItem("Double Angle Sine", "sin 2A = 2 sin A cos A = 2 tan A / (1 + tan² A)", "Sine double angle"),
                FormulaItem("Double Angle Cosine", "cos 2A = cos² A - sin² A = 2cos² A - 1 = 1 - 2sin² A", "Cosine double angle")
            ),
            definitions = listOf(
                "Radian" to "Angle subtended at the center of a circle by an arc whose length equals the radius.",
                "Periodic Function" to "f(x + T) = f(x) for all x in domain, where T is the smallest positive period."
            ),
            examples = listOf(
                SolvedExample(
                    question = "Find the value of sin 15° using compound angle formula.",
                    solution = "sin 15° = sin(45° - 30°)\n= sin 45° cos 30° - cos 45° sin 30°\n= (1/√2)(√3/2) - (1/√2)(1/2)\n= (√3 - 1) / (2√2).",
                    keyStep = "Expand using sin(A - B) with known standard angles 45° and 30°."
                )
            ),
            practiceQuestions = listOf(
                PracticeQuestion("Find the degree measure of 7π/6 radians.", "Multiply by 180/π", "210°")
            ),
            mcqs = listOf(
                McqQuestion("m3_1", "What is the value of cos 75°?", listOf("(√3 + 1)/2√2", "(√3 - 1)/2√2", "(1 - √3)/2√2", "1/2"), 1, "cos(45° + 30°) = cos 45 cos 30 - sin 45 sin 30 = (√3 - 1) / 2√2.", "Trigonometric Functions", SubjectType.MATHEMATICS)
            ),
            quickRevision = listOf(
                "sin(-θ) = -sin θ (odd), cos(-θ) = cos θ (even).",
                "Trig values repeat every full rotation: sin(2kπ + θ) = sin θ."
            )
        ),
        Chapter(
            id = "math_ch4",
            number = 4,
            subject = SubjectType.MATHEMATICS,
            title = "Principle of Mathematical Induction",
            overview = "Mathematical Induction is a powerful technique used to prove statements, theorems, and formulas asserted about all natural numbers n.",
            keyPoints = listOf(
                "Base Step: Verify P(1) is true.",
                "Inductive Hypothesis: Assume P(k) is true for some positive integer k.",
                "Inductive Step: Prove that P(k + 1) is true based on the assumption that P(k) is true.",
                "Conclusion: By PMI, P(n) is true for all natural numbers n ∈ N."
            ),
            formulas = listOf(
                FormulaItem("Sum of First n Naturals", "1 + 2 + ... + n = n(n + 1) / 2", "Standard formula"),
                FormulaItem("Sum of Squares", "1² + 2² + ... + n² = n(n + 1)(2n + 1) / 6", "Sum of first n squares"),
                FormulaItem("Sum of Cubes", "1³ + 2³ + ... + n³ = [n(n + 1) / 2]²", "Sum of first n cubes")
            ),
            definitions = listOf(
                "Inductive Step" to "The reasoning step showing that if a property holds for k, it inevitably holds for k + 1."
            ),
            examples = listOf(
                SolvedExample(
                    question = "Prove 1 + 2 + ... + n = n(n + 1)/2 for n = 1.",
                    solution = "LHS for n = 1 is 1.\nRHS = 1(1 + 1)/2 = 2/2 = 1.\nLHS = RHS, so P(1) is true.",
                    keyStep = "Base case verification."
                )
            ),
            practiceQuestions = listOf(
                PracticeQuestion("What is the sum of cubes of first 4 natural numbers?", "Use [4(5)/2]²", "10² = 100")
            ),
            mcqs = listOf(
                McqQuestion("m4_1", "What is the value of 1² + 2² + 3² + 4² + 5²?", listOf("45", "55", "65", "75"), 1, "Formula: 5 × 6 × 11 / 6 = 55.", "Principle of Mathematical Induction", SubjectType.MATHEMATICS)
            ),
            quickRevision = listOf(
                "Induction applies strictly to well-ordered discrete sets like N."
            )
        ),
        Chapter(
            id = "math_ch5",
            number = 5,
            subject = SubjectType.MATHEMATICS,
            title = "Complex Numbers & Quadratic Equations",
            overview = "Need for complex numbers arising from non-real roots of quadratic equations. Real and imaginary parts, modulus, conjugate, Argand plane, and polar form.",
            keyPoints = listOf(
                "Imaginary unit i = √(-1). Powers: i² = -1, i³ = -i, i⁴ = 1.",
                "Complex number z = a + ib, where a = Re(z), b = Im(z).",
                "Conjugate z̄ = a - ib.",
                "Modulus |z| = √(a² + b²)."
            ),
            formulas = listOf(
                FormulaItem("Modulus", "|z| = √(a² + b²)", "Distance from origin in Argand plane"),
                FormulaItem("Polar Form", "z = r(cos θ + i sin θ)", "r = |z|, θ = arg(z)"),
                FormulaItem("Roots of Quadratic", "x = (-b ± √(b² - 4ac)) / (2a)", "When b² - 4ac < 0, roots are complex conjugates")
            ),
            definitions = listOf(
                "Argument" to "The angle θ made by the vector representation of z with positive real axis, -π < θ ≤ π (Principal argument)."
            ),
            examples = listOf(
                SolvedExample(
                    question = "Find the multiplicative inverse of z = 4 - 3i.",
                    solution = "z⁻¹ = z̄ / |z|²\nz̄ = 4 + 3i\n|z|² = 4² + (-3)² = 16 + 9 = 25\nz⁻¹ = (4 + 3i) / 25 = 4/25 + (3/25)i.",
                    keyStep = "Divide conjugate by square of modulus."
                )
            ),
            practiceQuestions = listOf(
                PracticeQuestion("Evaluate i¹⁹.", "19 = 4 × 4 + 3", "i³ = -i")
            ),
            mcqs = listOf(
                McqQuestion("m5_1", "What is the modulus of 3 - 4i?", listOf("3", "4", "5", "7"), 2, "|3 - 4i| = √(3² + (-4)²) = √(9 + 16) = √25 = 5.", "Complex Numbers", SubjectType.MATHEMATICS)
            ),
            quickRevision = listOf(
                "z · z̄ = |z|².",
                "The square root of a negative real number -a is i√a."
            )
        ),
        Chapter(
            id = "math_ch6",
            number = 6,
            subject = SubjectType.MATHEMATICS,
            title = "Linear Inequalities",
            overview = "Inequalities involving real numbers. Algebraic solutions of linear inequalities in one variable and graphical representation.",
            keyPoints = listOf(
                "Multiplying or dividing both sides of an inequality by a negative number reverses the inequality sign.",
                "Equal numbers may be added to or subtracted from both sides without changing the sign.",
                "Solution sets are written in interval notation: (a, b), [a, b], [a, b), (a, b]."
            ),
            formulas = listOf(
                FormulaItem("Absolute Value Inequality (<)", "|x| < a  ⇔  -a < x < a", "Bounded open interval"),
                FormulaItem("Absolute Value Inequality (>)", "|x| > a  ⇔  x < -a or x > a", "Two disjoint half-lines")
            ),
            definitions = listOf(
                "Linear Inequality" to "Two real numbers or algebraic expressions related by the symbol '<', '>', '≤' or '≥'."
            ),
            examples = listOf(
                SolvedExample(
                    question = "Solve: 3x - 5 < 5x - 1.",
                    solution = "3x - 5x < -1 + 5\n-2x < 4\nDivide by -2 (reverse sign!): x > -2\nSolution set: (-2, ∞).",
                    keyStep = "Remember to reverse inequality when dividing by -2."
                )
            ),
            practiceQuestions = listOf(
                PracticeQuestion("Solve: |x - 2| ≤ 3.", "Expand -3 ≤ x - 2 ≤ 3", "[-1, 5]")
            ),
            mcqs = listOf(
                McqQuestion("m6_1", "If -3x + 17 < -13, then which is true?", listOf("x < 10", "x > 10", "x ≤ 10", "x ≥ 10"), 1, "-3x < -30 ⇒ x > 10.", "Linear Inequalities", SubjectType.MATHEMATICS)
            ),
            quickRevision = listOf(
                "Round bracket ( ) excludes endpoint; square bracket [ ] includes endpoint."
            )
        ),
        Chapter(
            id = "math_ch7",
            number = 7,
            subject = SubjectType.MATHEMATICS,
            title = "Permutations and Combinations",
            overview = "Fundamental principle of counting, factorial notation, permutations (arrangements) and combinations (selections).",
            keyPoints = listOf(
                "Fundamental Principle of Multiplication: If an event can occur in m ways and another in n ways, both occur in m × n ways.",
                "Factorial n! = n × (n - 1) × ... × 1. By convention 0! = 1.",
                "Permutation is an ordered arrangement. Combination is a selection where order does not matter."
            ),
            formulas = listOf(
                FormulaItem("Permutations Formula", "ⁿPᵣ = n! / (n - r)!", "Arrangements of n distinct items taken r at a time"),
                FormulaItem("Combinations Formula", "ⁿCᵣ = n! / (r! · (n - r)!)", "Selections of n items taken r at a time"),
                FormulaItem("Symmetry Property", "ⁿCᵣ = ⁿCₙ₋ᵣ", "Useful for calculations")
            ),
            definitions = listOf(
                "Permutation" to "An arrangement in a definite order of a number of objects taken some or all at a time.",
                "Combination" to "Each of the different selections made by taking some or all of a number of objects."
            ),
            examples = listOf(
                SolvedExample(
                    question = "Evaluate ⁵P₂ and ⁵C₂.",
                    solution = "⁵P₂ = 5! / (5 - 2)! = 5 × 4 = 20.\n⁵C₂ = 5! / (2! × 3!) = (5 × 4) / 2 = 10.",
                    keyStep = "Notice ⁿPᵣ = r! × ⁿCᵣ."
                )
            ),
            practiceQuestions = listOf(
                PracticeQuestion("How many 3-digit numbers can be formed from digits 1, 2, 3, 4, 5 without repetition?", "5 × 4 × 3", "60 numbers")
            ),
            mcqs = listOf(
                McqQuestion("m7_1", "What is the value of ¹⁰C₂?", listOf("20", "45", "90", "100"), 1, "¹⁰C₂ = (10 × 9) / 2 = 45.", "Permutations and Combinations", SubjectType.MATHEMATICS)
            ),
            quickRevision = listOf(
                "ⁿC₀ = ⁿCₙ = 1.",
                "ⁿCᵣ + ⁿCᵣ₋₁ = ⁿ⁺¹Cᵣ (Pascal's Identity)."
            )
        ),
        Chapter(
            id = "math_ch8",
            number = 8,
            subject = SubjectType.MATHEMATICS,
            title = "Binomial Theorem",
            overview = "Expansion of a binomial for any positive integral exponent. Pascal's triangle, general term and middle term.",
            keyPoints = listOf(
                "The expansion (a + b)ⁿ contains (n + 1) terms.",
                "Sum of exponents of a and b in each term is always n.",
                "Coefficients equidistant from beginning and end are equal: ⁿCᵣ = ⁿCₙ₋ᵣ."
            ),
            formulas = listOf(
                FormulaItem("Binomial Expansion", "(a + b)ⁿ = Σ (ⁿCᵣ aⁿ⁻ʳ bʳ) from r=0 to n", "Full expansion"),
                FormulaItem("General Term", "Tᵣ₊₁ = ⁿCᵣ aⁿ⁻ʳ bʳ", "The (r + 1)-th term")
            ),
            definitions = listOf(
                "Binomial Expression" to "An algebraic expression consisting of two terms connected by + or -."
            ),
            examples = listOf(
                SolvedExample(
                    question = "Find the 4th term in the expansion of (x - 2y)¹².",
                    solution = "Here n = 12, a = x, b = -2y. For 4th term, r = 3.\nT₄ = T₃₊₁ = ¹²C₃ · x¹²⁻³ · (-2y)³\n= (12 × 11 × 10 / 6) · x⁹ · (-8y³)\n= 220 · (-8) x⁹y³ = -1760 x⁹y³.",
                    keyStep = "Set r = 3 for the 4th term and keep the negative sign with b."
                )
            ),
            practiceQuestions = listOf(
                PracticeQuestion("How many terms are in the expansion of (2x + 3y)⁷?", "Total terms = n + 1", "8 terms")
            ),
            mcqs = listOf(
                McqQuestion("m8_1", "What is the sum of coefficients in (1 + x)ⁿ?", listOf("n", "2ⁿ", "2ⁿ⁻¹", "n²"), 1, "Put x = 1: (1 + 1)ⁿ = 2ⁿ.", "Binomial Theorem", SubjectType.MATHEMATICS)
            ),
            quickRevision = listOf(
                "Number of terms in (a + b)ⁿ is n + 1."
            )
        ),
        Chapter(
            id = "math_ch9",
            number = 9,
            subject = SubjectType.MATHEMATICS,
            title = "Sequences and Series",
            overview = "Arithmetic Progression (AP) review, Geometric Progression (GP), general term, sum of n terms, infinite GP, and Arithmetic-Geometric Means.",
            keyPoints = listOf(
                "In AP, difference between consecutive terms is constant d.",
                "In GP, ratio between consecutive terms is constant r.",
                "Arithmetic Mean AM = (a + b)/2. Geometric Mean GM = √(ab). AM ≥ GM."
            ),
            formulas = listOf(
                FormulaItem("GP n-th Term", "aₙ = a · rⁿ⁻¹", "General term of GP"),
                FormulaItem("GP Sum of n Terms", "Sₙ = a(1 - rⁿ) / (1 - r) for r ≠ 1", "Finite GP sum"),
                FormulaItem("Sum of Infinite GP", "S_∞ = a / (1 - r) for |r| < 1", "Convergent infinite GP"),
                FormulaItem("AM-GM Inequality", "AM ≥ GM  ⇒  (a + b)/2 ≥ √(ab)", "For positive numbers")
            ),
            definitions = listOf(
                "Geometric Progression" to "A sequence in which each term after the first is obtained by multiplying the preceding term by a fixed non-zero constant."
            ),
            examples = listOf(
                SolvedExample(
                    question = "Find the sum of the infinite series 1 + 1/2 + 1/4 + 1/8 + ...",
                    solution = "Here first term a = 1, common ratio r = 1/2. Since |r| < 1:\nS_∞ = a / (1 - r) = 1 / (1 - 1/2) = 1 / (1/2) = 2.",
                    keyStep = "Formula for infinite GP: a / (1 - r)."
                )
            ),
            practiceQuestions = listOf(
                PracticeQuestion("Find the 10th term of GP: 5, 25, 125, ...", "a = 5, r = 5, a₁₀ = 5 × 5⁹", "5¹⁰ = 9,765,625")
            ),
            mcqs = listOf(
                McqQuestion("m9_1", "If AM and GM of two positive numbers are 10 and 8, what are the numbers?", listOf("16 and 4", "12 and 8", "14 and 6", "18 and 2"), 0, "(16+4)/2 = 10, and √(16 × 4) = √64 = 8.", "Sequences and Series", SubjectType.MATHEMATICS)
            ),
            quickRevision = listOf(
                "For any two positive unequal numbers, AM > GM."
            )
        ),
        Chapter(
            id = "math_ch10",
            number = 10,
            subject = SubjectType.MATHEMATICS,
            title = "Straight Lines",
            overview = "Slope of a line, angle between two lines, various forms of equations of a line (point-slope, two-point, slope-intercept, intercept, normal), distance of a point from a line.",
            keyPoints = listOf(
                "Slope m = tan θ = (y₂ - y₁) / (x₂ - x₁).",
                "Two lines with slopes m₁ and m₂ are parallel if m₁ = m₂.",
                "Two lines are perpendicular if m₁ · m₂ = -1.",
                "General equation: Ax + By + C = 0."
            ),
            formulas = listOf(
                FormulaItem("Slope-Intercept Form", "y = mx + c", "m is slope, c is y-intercept"),
                FormulaItem("Point-Slope Form", "y - y₁ = m(x - x₁)", "Line passing through (x₁, y₁)"),
                FormulaItem("Distance Point to Line", "d = |Ax₁ + By₁ + C| / √(A² + B²)", "Perpendicular distance from (x₁, y₁)"),
                FormulaItem("Angle between Lines", "tan θ = |(m₂ - m₁) / (1 + m₁m₂)|", "Acute angle")
            ),
            definitions = listOf(
                "Slope" to "The tangent of the angle of inclination that a line makes with the positive x-axis."
            ),
            examples = listOf(
                SolvedExample(
                    question = "Find the distance of the point (3, -5) from the line 3x - 4y - 26 = 0.",
                    solution = "d = |3(3) - 4(-5) - 26| / √(3² + (-4)²)\n= |9 + 20 - 26| / √25\n= |3| / 5 = 3/5 units.",
                    keyStep = "Substitute coordinates into perpendicular distance formula."
                )
            ),
            practiceQuestions = listOf(
                PracticeQuestion("Find the slope of a line perpendicular to line with slope 2/3.", "m · m' = -1", "-3/2")
            ),
            mcqs = listOf(
                McqQuestion("m10_1", "What is the slope of line 2x + 3y = 6?", listOf("2/3", "-2/3", "3/2", "-3/2"), 1, "Rearranging to y = mx + c gives y = (-2/3)x + 2, so slope is -2/3.", "Straight Lines", SubjectType.MATHEMATICS)
            ),
            quickRevision = listOf(
                "Slope of horizontal line is 0, slope of vertical line is undefined."
            )
        ),
        Chapter(
            id = "math_ch11",
            number = 11,
            subject = SubjectType.MATHEMATICS,
            title = "Conic Sections",
            overview = "Sections of a cone: Circle, Parabola, Ellipse, Hyperbola. Standard equations, foci, directrix, eccentricity, and latus rectum.",
            keyPoints = listOf(
                "Circle: Set of all points equidistant from center (h, k). (x - h)² + (y - k)² = r².",
                "Parabola (e = 1): Standard equation y² = 4ax. Focus (a, 0), directrix x = -a, latus rectum = 4a.",
                "Ellipse (e < 1): Standard equation x²/a² + y²/b² = 1. b² = a²(1 - e²).",
                "Hyperbola (e > 1): Standard equation x²/a² - y²/b² = 1. b² = a²(e² - 1)."
            ),
            formulas = listOf(
                FormulaItem("Standard Circle", "x² + y² = r²", "Center at origin (0, 0)"),
                FormulaItem("Parabola", "y² = 4ax", "Focus at (a, 0), directrix x = -a"),
                FormulaItem("Ellipse Latus Rectum", "L = 2b² / a", "Length of latus rectum"),
                FormulaItem("Hyperbola Eccentricity", "e = √(1 + b²/a²)", "e > 1 always")
            ),
            definitions = listOf(
                "Eccentricity" to "Ratio of the distance of a point on the conic from the focus to its distance from the directrix."
            ),
            examples = listOf(
                SolvedExample(
                    question = "Find the coordinates of focus and length of latus rectum for y² = 12x.",
                    solution = "Compare with y² = 4ax:\n4a = 12  ⇒  a = 3.\nFocus = (a, 0) = (3, 0).\nLength of latus rectum = 4a = 12.",
                    keyStep = "Equate 4a to the coefficient of x."
                )
            ),
            practiceQuestions = listOf(
                PracticeQuestion("Find radius of circle x² + y² - 4x + 6y - 12 = 0.", "r = √(g² + f² - c) = √(2² + (-3)² - (-12))", "5")
            ),
            mcqs = listOf(
                McqQuestion("m11_1", "What is the eccentricity of a parabola?", listOf("0", "1", "< 1", "> 1"), 1, "A parabola has eccentricity e = 1.", "Conic Sections", SubjectType.MATHEMATICS)
            ),
            quickRevision = listOf(
                "e = 0 (Circle), e = 1 (Parabola), e < 1 (Ellipse), e > 1 (Hyperbola)."
            )
        ),
        Chapter(
            id = "math_ch12",
            number = 12,
            subject = SubjectType.MATHEMATICS,
            title = "Introduction to Three Dimensional Geometry",
            overview = "Coordinate axes and coordinate planes in 3D space. Coordinates of a point, distance between two points, and section formula.",
            keyPoints = listOf(
                "Three mutually perpendicular planes divide space into 8 octants.",
                "Point in space represented as P(x, y, z).",
                "Distance from origin: OP = √(x² + y² + z²)."
            ),
            formulas = listOf(
                FormulaItem("Distance Formula in 3D", "d = √((x₂ - x₁)² + (y₂ - y₁)² + (z₂ - z₁)²)", "Distance between two points"),
                FormulaItem("Section Formula", "P = ((mx₂ + nx₁)/(m+n), (my₂ + ny₁)/(m+n), (mz₂ + nz₁)/(m+n))", "Internal division ratio m:n"),
                FormulaItem("Midpoint Formula", "M = ((x₁+x₂)/2, (y₁+y₂)/2, (z₁+z₂)/2)", "Coordinates of midpoint")
            ),
            definitions = listOf(
                "Octant" to "One of the eight parts into which 3D space is divided by three coordinate planes."
            ),
            examples = listOf(
                SolvedExample(
                    question = "Find distance between points P(1, -3, 4) and Q(-4, 1, 2).",
                    solution = "d = √((-4 - 1)² + (1 - (-3))² + (2 - 4)²)\n= √((-5)² + 4² + (-2)²)\n= √(25 + 16 + 4) = √45 = 3√5.",
                    keyStep = "Apply 3D distance formula."
                )
            ),
            practiceQuestions = listOf(
                PracticeQuestion("Find midpoint of segment joining (2, 3, 4) and (4, 1, -2).", "Add coordinates and divide by 2", "(3, 2, 1)")
            ),
            mcqs = listOf(
                McqQuestion("m12_1", "The point (-2, 4, -3) lies in which octant?", listOf("II", "IV", "V", "VI"), 3, "Signs are (-, +, -) which corresponds to Octant VI.", "Introduction to 3D Geometry", SubjectType.MATHEMATICS)
            ),
            quickRevision = listOf(
                "Any point on x-axis has coordinates (x, 0, 0)."
            )
        ),
        Chapter(
            id = "math_ch13",
            number = 13,
            subject = SubjectType.MATHEMATICS,
            title = "Limits and Derivatives",
            overview = "Intuitive idea of limits. Limits of polynomials and rational functions. Trigonometric limits. Derivative as rate of change and slope of tangent.",
            keyPoints = listOf(
                "Limit of f(x) as x → a exists if Left Hand Limit = Right Hand Limit.",
                "Standard trig limit: lim(x→0) (sin x / x) = 1 (where x is in radians).",
                "Derivative f'(x) = lim(h→0) [f(x + h) - f(x)] / h."
            ),
            formulas = listOf(
                FormulaItem("Power Rule", "d/dx (xⁿ) = n xⁿ⁻¹", "Basic derivative rule"),
                FormulaItem("Trig Limit", "lim(x→0) (sin x / x) = 1", "Fundamental trigonometric limit"),
                FormulaItem("Product Rule", "d/dx [u · v] = u'v + uv'", "Leibniz product rule"),
                FormulaItem("Quotient Rule", "d/dx [u / v] = (u'v - uv') / v²", "Quotient rule for fractions")
            ),
            definitions = listOf(
                "Derivative" to "The instantaneous rate of change of a function with respect to its variable."
            ),
            examples = listOf(
                SolvedExample(
                    question = "Evaluate lim(x→0) [sin 4x / x].",
                    solution = "Multiply numerator and denominator by 4:\nlim(x→0) 4 · [sin 4x / 4x] = 4 · 1 = 4.",
                    keyStep = "Match the argument inside sine with denominator."
                )
            ),
            practiceQuestions = listOf(
                PracticeQuestion("Find the derivative of f(x) = x³ - 4x + 7.", "Apply power rule term-by-term", "3x² - 4")
            ),
            mcqs = listOf(
                McqQuestion("m13_1", "What is the derivative of sin x with respect to x?", listOf("cos x", "-cos x", "tan x", "-sin x"), 0, "d/dx (sin x) = cos x.", "Limits and Derivatives", SubjectType.MATHEMATICS)
            ),
            quickRevision = listOf(
                "d/dx (constant) = 0.",
                "d/dx (cos x) = -sin x."
            )
        ),
        Chapter(
            id = "math_ch14",
            number = 14,
            subject = SubjectType.MATHEMATICS,
            title = "Statistics",
            overview = "Measures of dispersion: Range, Mean deviation, Variance and Standard deviation of ungrouped and grouped data. Coefficient of variation.",
            keyPoints = listOf(
                "Dispersion measures the degree of scattering of data around central value.",
                "Mean Deviation can be computed about Mean or about Median.",
                "Variance σ² is the mean of squared deviations from the arithmetic mean.",
                "Standard Deviation σ = +√(Variance)."
            ),
            formulas = listOf(
                FormulaItem("Variance (Ungrouped)", "σ² = (1/n) Σ(xᵢ - x̄)²", "Mean of squared deviations"),
                FormulaItem("Standard Deviation", "σ = √[ (1/n) Σ(xᵢ - x̄)² ]", "Positive square root of variance"),
                FormulaItem("Coefficient of Variation", "CV = (σ / x̄) × 100", "Measure of relative variability")
            ),
            definitions = listOf(
                "Standard Deviation" to "The positive square root of the arithmetic mean of squares of deviations from arithmetic mean."
            ),
            examples = listOf(
                SolvedExample(
                    question = "If the variance of a dataset is 25, what is its standard deviation?",
                    solution = "σ = √(Variance) = √25 = 5.",
                    keyStep = "Take positive square root."
                )
            ),
            practiceQuestions = listOf(
                PracticeQuestion("Find the range of numbers: 4, 9, 12, 18, 3, 22.", "Range = Max - Min = 22 - 3", "19")
            ),
            mcqs = listOf(
                McqQuestion("m14_1", "Which measure of dispersion is free from units?", listOf("Range", "Variance", "Standard Deviation", "Coefficient of Variation"), 3, "CV is a dimensionless relative measure expressed as a percentage.", "Statistics", SubjectType.MATHEMATICS)
            ),
            quickRevision = listOf(
                "A distribution with smaller CV is more consistent and less dispersed."
            )
        ),
        Chapter(
            id = "math_ch15",
            number = 15,
            subject = SubjectType.MATHEMATICS,
            title = "Probability",
            overview = "Random experiments, sample space, events (exhaustive, mutually exclusive), axiomatic approach to probability.",
            keyPoints = listOf(
                "Sample space S is the set of all possible outcomes of a random experiment.",
                "Probability P(E) = n(E) / n(S) for equally likely outcomes.",
                "0 ≤ P(E) ≤ 1. P(∅) = 0 and P(S) = 1.",
                "Mutually exclusive events cannot occur simultaneously: P(A ∩ B) = 0."
            ),
            formulas = listOf(
                FormulaItem("Addition Theorem", "P(A ∪ B) = P(A) + P(B) - P(A ∩ B)", "For any two events"),
                FormulaItem("Mutually Exclusive Events", "P(A ∪ B) = P(A) + P(B)", "When A ∩ B = ∅"),
                FormulaItem("Complementary Event", "P(A') = 1 - P(A)", "Probability of not A")
            ),
            definitions = listOf(
                "Sample Space" to "The set of all possible outcomes of a random experiment.",
                "Mutually Exclusive Events" to "Events that have no common outcomes."
            ),
            examples = listOf(
                SolvedExample(
                    question = "A coin is tossed twice. What is the probability of getting at least one head?",
                    solution = "Sample space S = {HH, HT, TH, TT}. n(S) = 4.\nFavorable outcomes E = {HH, HT, TH}. n(E) = 3.\nP(E) = 3/4 = 0.75.",
                    keyStep = "Count outcomes with at least one H."
                )
            ),
            practiceQuestions = listOf(
                PracticeQuestion("If P(A) = 0.65, find P(not A).", "P(A') = 1 - P(A)", "0.35")
            ),
            mcqs = listOf(
                McqQuestion("m15_1", "If two dice are thrown together, what is the total number of outcomes in sample space?", listOf("12", "36", "64", "216"), 1, "6 × 6 = 36 outcomes.", "Probability", SubjectType.MATHEMATICS)
            ),
            quickRevision = listOf(
                "Sum of probabilities of all elementary events is 1."
            )
        )
    )
}
