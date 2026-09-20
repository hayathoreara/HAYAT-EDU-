package com.example.data.repository

import com.example.data.model.*

object ChemistryData {
    val chapters: List<Chapter> = listOf(
        Chapter(
            id = "chem_ch1",
            number = 1,
            subject = SubjectType.CHEMISTRY,
            title = "Some Basic Concepts of Chemistry",
            overview = "Importance of chemistry, nature of matter, laws of chemical combination, Dalton's atomic theory, mole concept, molar mass, stoichiometry and calculations based on stoichiometry.",
            keyPoints = listOf(
                "1 Mole contains 6.022 × 10²³ entities (Avogadro's constant N_A).",
                "Molarity M = moles of solute / volume of solution in liters (mol/L). Temperature dependent.",
                "Molality m = moles of solute / mass of solvent in kg (mol/kg). Temperature independent.",
                "Empirical formula represents simplest whole-number ratio of atoms in compound; Molecular formula = n × (Empirical formula)."
            ),
            formulas = listOf(
                FormulaItem("Number of Moles", "n = mass (g) / Molar mass (g/mol) = N / N_A", "Fundamental mole calculation"),
                FormulaItem("Molarity", "M = n_solute / V_solution (L)", "Concentration in mol/L", "mol/L", "-"),
                FormulaItem("Molality", "m = n_solute / W_solvent (kg)", "Concentration in mol/kg", "mol/kg", "-"),
                FormulaItem("Mole Fraction", "x_A = n_A / (n_A + n_B)", "Sum of all mole fractions Σxᵢ = 1", "-", "-")
            ),
            definitions = listOf(
                "Limiting Reagent" to "The reactant that gets completely consumed first in a reaction and limits the amount of product formed.",
                "Avogadro's Law" to "Equal volumes of all gases under identical conditions of temperature and pressure contain equal numbers of molecules."
            ),
            examples = listOf(
                SolvedExample(
                    question = "Calculate the mass of 0.5 moles of water (H₂O).",
                    solution = "Molar mass of H₂O = 2(1.008) + 16.00 = 18.016 g/mol.\nMass = moles × molar mass = 0.5 × 18 = 9.0 g.",
                    keyStep = "Multiply moles by molar mass."
                )
            ),
            practiceQuestions = listOf(
                PracticeQuestion("Calculate the molarity of a solution containing 4 g of NaOH in 250 mL of water.", "Moles of NaOH = 4 / 40 = 0.1 mol. Volume = 0.25 L", "0.1 / 0.25 = 0.4 M")
            ),
            mcqs = listOf(
                McqQuestion("c1_1", "Which concentration unit does NOT change with change in temperature?", listOf("Molarity", "Normality", "Molality", "Volume percentage"), 2, "Molality depends only on mass of solvent, which is temperature-invariant.", "Basic Concepts of Chemistry", SubjectType.CHEMISTRY)
            ),
            quickRevision = listOf(
                "At STP (standard temperature 273.15 K and 1 bar), 1 mole of any ideal gas occupies 22.7 Liters (or 22.4 L at 1 atm)."
            )
        ),
        Chapter(
            id = "chem_ch2",
            number = 2,
            subject = SubjectType.CHEMISTRY,
            title = "Structure of Atom",
            overview = "Discovery of subatomic particles, Bohr's model of atom, dual behavior of matter and light, de Broglie relation, Heisenberg uncertainty principle, quantum mechanical model, and quantum numbers.",
            keyPoints = listOf(
                "Bohr frequency condition: ΔE = E₂ - E₁ = h·ν. Angular momentum quantization: mvr = n h / (2π).",
                "de Broglie relation: λ = h / p = h / (m v). Matter exhibits wave-particle duality.",
                "Heisenberg Uncertainty Principle: Δx · Δp ≥ h / (4π).",
                "Four Quantum Numbers: Principal (n), Azimuthal (l = 0 to n-1), Magnetic (m_l = -l to +l), Spin (m_s = ±1/2)."
            ),
            formulas = listOf(
                FormulaItem("Energy of Photon", "E = h · ν = h · c / λ", "h = 6.626 × 10⁻³⁴ J·s", "Joule (J)", "-"),
                FormulaItem("Rydberg Formula", "1/λ = R_H · Z² · (1/n₁² - 1/n₂²)", "R_H = 109,677 cm⁻¹", "m⁻¹", "-"),
                FormulaItem("de Broglie Wavelength", "λ = h / (m · v)", "Wave nature of particles", "meter (m)", "[L]"),
                FormulaItem("Uncertainty Principle", "Δx · Δp ≥ h / (4π)", "Conjugate variables limitation", "J·s", "-")
            ),
            definitions = listOf(
                "Aufbau Principle" to "In the ground state of atoms, orbitals are filled in order of increasing energies (n + l rule).",
                "Pauli Exclusion Principle" to "No two electrons in an atom can have the identical set of all four quantum numbers.",
                "Hund's Rule" to "Pairing of electrons in degenerate orbitals does not occur until each orbital is singly occupied with parallel spins."
            ),
            examples = listOf(
                SolvedExample(
                    question = "Find the energy of a photon of light having frequency 5 × 10¹⁴ Hz (Planck constant h = 6.626 × 10⁻³⁴ J·s).",
                    solution = "E = h · ν = 6.626 × 10⁻³⁴ × 5 × 10¹⁴\n= 33.13 × 10⁻²⁰ = 3.313 × 10⁻¹⁹ Joules.",
                    keyStep = "Use photoelectric equation E = hν."
                )
            ),
            practiceQuestions = listOf(
                PracticeQuestion("What are the total number of orbitals associated with principal quantum number n = 3?", "Total orbitals in n shell = n²", "3² = 9 orbitals (1s, 3p, 5d)")
            ),
            mcqs = listOf(
                McqQuestion("c2_1", "Which orbital has spherical symmetry?", listOf("p-orbital", "d-orbital", "s-orbital", "f-orbital"), 2, "s-orbitals have l = 0 and are spherically symmetrical about the nucleus.", "Structure of Atom", SubjectType.CHEMISTRY)
            ),
            quickRevision = listOf(
                "Maximum electrons in a shell = 2n².",
                "Balmer series lines fall in the visible region of electromagnetic spectrum (n₁ = 2)."
            )
        ),
        Chapter(
            id = "chem_ch3",
            number = 3,
            subject = SubjectType.CHEMISTRY,
            title = "Classification of Elements & Periodicity",
            overview = "Modern periodic law and present form of periodic table, electronic configurations, blocks (s, p, d, f), periodic trends in properties of elements (atomic radii, ionization enthalpy, electron gain enthalpy, electronegativity).",
            keyPoints = listOf(
                "Modern Periodic Law (Moseley): Physical and chemical properties of elements are periodic functions of their atomic numbers.",
                "Atomic radius decreases across a period (increasing nuclear charge) and increases down a group (additional shells).",
                "Ionization Enthalpy generally increases across a period and decreases down a group.",
                "Fluorine has the highest electronegativity (4.0 on Pauling scale); Chlorine has the most negative electron gain enthalpy."
            ),
            formulas = listOf(
                FormulaItem("Effective Nuclear Charge", "Z_eff = Z - σ", "σ is Slater's shielding constant"),
                FormulaItem("Pauling Electronegativity Difference", "|χ_A - χ_B| = 0.208 √(Δ)", "Δ in kcal/mol")
            ),
            definitions = listOf(
                "Ionization Enthalpy" to "Energy required to remove the most loosely bound electron from an isolated gaseous atom in ground state.",
                "Electronegativity" to "The tendency of an atom in a chemical compound to attract shared pair of electrons towards itself."
            ),
            examples = listOf(
                SolvedExample(
                    question = "Why is the first ionization enthalpy of Nitrogen higher than that of Oxygen?",
                    solution = "Nitrogen has half-filled 2p³ configuration (1s² 2s² 2p³), which confers extra quantum mechanical exchange stability. Oxygen (1s² 2s² 2p⁴) has paired electron repulsion, making electron removal easier.",
                    keyStep = "Compare half-filled stability of 2p³ vs 2p⁴."
                )
            ),
            practiceQuestions = listOf(
                PracticeQuestion("Why is electron gain enthalpy of Chlorine more negative than that of Fluorine?", "Fluorine has compact 2p subshell with high electron-electron repulsion", "Chlorine accommodates incoming electron into larger 3p subshell")
            ),
            mcqs = listOf(
                McqQuestion("c3_1", "Which element has the highest electronegativity in the periodic table?", listOf("Cesium", "Oxygen", "Chlorine", "Fluorine"), 3, "Fluorine is the most electronegative element (Pauling value 4.0).", "Classification of Elements", SubjectType.CHEMISTRY)
            ),
            quickRevision = listOf(
                "Noble gases have positive electron gain enthalpies due to stable octet configurations."
            )
        ),
        Chapter(
            id = "chem_ch4",
            number = 4,
            subject = SubjectType.CHEMISTRY,
            title = "Chemical Bonding & Molecular Structure",
            overview = "Ionic and covalent bonds, Lewis structures, octet rule, resonance, VSEPR theory, hybridization (sp, sp², sp³, sp³d), molecular orbital theory (MOT), and hydrogen bonding.",
            keyPoints = listOf(
                "VSEPR Theory: Molecular geometry is determined by repulsions between valence shell electron pairs (lp-lp > lp-bp > bp-bp).",
                "Hybridization mixes atomic orbitals to form equivalent hybrid orbitals: sp (linear, 180°), sp² (trigonal planar, 120°), sp³ (tetrahedral, 109.5°).",
                "Molecular Orbital Theory (MOT): Bond Order = 1/2 (N_b - N_a). Molecule is stable if N_b > N_a.",
                "Paramagnetism arises from presence of unpaired electrons (e.g. O₂ has 2 unpaired electrons in π*2p orbitals)."
            ),
            formulas = listOf(
                FormulaItem("Bond Order", "Bond Order = (N_b - N_a) / 2", "N_b = bonding electrons, N_a = antibonding electrons"),
                FormulaItem("Formal Charge", "FC = V - L - (1/2) S", "V = valence e⁻, L = lone pair e⁻, S = shared e⁻"),
                FormulaItem("Dipole Moment", "μ = q · d", "Unit: Debye (1 D = 3.33564 × 10⁻³⁰ C·m)")
            ),
            definitions = listOf(
                "Hydrogen Bond" to "An attractive force between a hydrogen atom covalently bonded to an electronegative atom (N, O, F) and another electronegative atom.",
                "Hybridization" to "The concept of mixing atomic orbitals into new hybrid orbitals suitable for pairing electrons to form chemical bonds."
            ),
            examples = listOf(
                SolvedExample(
                    question = "Calculate the bond order and magnetic nature of O₂ molecule according to MOT.",
                    solution = "O₂ has 16 electrons.\nMO configuration: σ1s² σ*1s² σ2s² σ*2s² σ2p_z² (π2p_x² = π2p_y²) (π*2p_x¹ = π*2p_y¹)\nBonding electrons N_b = 10, Antibonding N_a = 6.\nBond Order = (10 - 6)/2 = 4/2 = 2 (double bond).\nBecause it possesses 2 unpaired electrons in π* orbitals, O₂ is paramagnetic.",
                    keyStep = "Apply MOT electron filling order."
                )
            ),
            practiceQuestions = listOf(
                PracticeQuestion("Predict the shape and bond angle of methane (CH₄) using VSEPR.", "4 bond pairs, 0 lone pairs  ⇒  sp³ hybridization", "Tetrahedral shape, 109.5° angle")
            ),
            mcqs = listOf(
                McqQuestion("c4_1", "What is the shape of water (H₂O) molecule?", listOf("Linear", "Trigonal planar", "Bent / V-shaped", "Tetrahedral"), 2, "Oxygen has 2 bond pairs and 2 lone pairs, causing lone pair-lone pair repulsion and a bent shape (bond angle 104.5°).", "Chemical Bonding", SubjectType.CHEMISTRY)
            ),
            quickRevision = listOf(
                "Higher bond order corresponds to shorter bond length and higher bond dissociation energy."
            )
        ),
        Chapter(
            id = "chem_ch5",
            number = 5,
            subject = SubjectType.CHEMISTRY,
            title = "Chemical Thermodynamics",
            overview = "System and surroundings, work, heat, internal energy, first law, enthalpy, Hess's law of constant heat summation, entropy, Gibbs energy, and spontaneity.",
            keyPoints = listOf(
                "First Law: ΔU = q + w. For expansion against constant external pressure, w = -P_ext ΔV.",
                "Enthalpy H = U + PV. ΔH = ΔU + Δn_g R T for reactions involving gases.",
                "Hess's Law: Enthalpy change of a reaction is identical whether it occurs in one step or in several steps.",
                "Spontaneity criterion: ΔG = ΔH - T ΔS. A process is spontaneous at constant T and P if ΔG < 0."
            ),
            formulas = listOf(
                FormulaItem("Enthalpy Relation", "ΔH = ΔU + Δn_g · R · T", "Δn_g = gaseous products moles - gaseous reactants moles"),
                FormulaItem("Gibbs Free Energy", "ΔG = ΔH - T · ΔS", "Spontaneity indicator (ΔG < 0 spontaneous)", "kJ/mol", "-"),
                FormulaItem("Equilibrium & Free Energy", "ΔG° = -2.303 R T log K_eq", "Relation between standard free energy and equilibrium constant")
            ),
            definitions = listOf(
                "Entropy" to "A thermodynamic measure of the molecular randomness or disorder of a system.",
                "Hess's Law" to "The total enthalpy change in a chemical reaction is independent of the pathway between initial and final states."
            ),
            examples = listOf(
                SolvedExample(
                    question = "For a reaction, ΔH = -100 kJ and ΔS = -100 J/K. At what temperature does the reaction become non-spontaneous?",
                    solution = "Set ΔG = 0: ΔH - T ΔS = 0  ⇒  T = ΔH / ΔS\n= (-100,000 J) / (-100 J/K) = 1000 K.\nAt T < 1000 K, ΔG < 0 (spontaneous); at T > 1000 K, ΔG > 0 (non-spontaneous).",
                    keyStep = "Convert ΔH to Joules before dividing by ΔS."
                )
            ),
            practiceQuestions = listOf(
                PracticeQuestion("What is the sign of ΔS for the vaporization of liquid water to steam?", "Gas has far higher disorder than liquid", "Positive (ΔS > 0)")
            ),
            mcqs = listOf(
                McqQuestion("c5_1", "Which of the following is an intensive property?", listOf("Mass", "Volume", "Density", "Enthalpy"), 2, "Density does not depend on the quantity of matter present, making it intensive.", "Chemical Thermodynamics", SubjectType.CHEMISTRY)
            ),
            quickRevision = listOf(
                "For isolated system, ΔS_total ≥ 0 (Second Law of Thermodynamics)."
            )
        ),
        Chapter(
            id = "chem_ch6",
            number = 6,
            subject = SubjectType.CHEMISTRY,
            title = "Equilibrium",
            overview = "Equilibrium in physical and chemical processes, dynamic nature, law of mass action, equilibrium constant (K_c, K_p), Le Chatelier's principle, ionic equilibrium, acids and bases, pH, buffer solutions, and solubility product.",
            keyPoints = listOf(
                "Dynamic equilibrium: Rate of forward reaction equals rate of backward reaction.",
                "Relation: K_p = K_c (R T)^(Δn_g).",
                "Le Chatelier's Principle: If a stress (concentration, pressure, temperature) is applied to equilibrium, system shifts to counteract it.",
                "pH = -log[H₃O⁺]. For pure water at 25 °C, K_w = [H⁺][OH⁻] = 1.0 × 10⁻¹⁴, pH = 7."
            ),
            formulas = listOf(
                FormulaItem("Relation between K_p and K_c", "K_p = K_c · (R · T)^(Δn_g)", "R = 0.0821 L·atm/(mol·K)"),
                FormulaItem("pH Definition", "pH = -log₁₀[H⁺]", "Acidic if pH < 7, Basic if pH > 7"),
                FormulaItem("Henderson-Hasselbalch Equation", "pH = pK_a + log([Salt] / [Acid])", "For acidic buffer"),
                FormulaItem("Solubility Product", "K_sp = [M⁺]ᵐ · [X⁻]ⁿ", "For sparingly soluble salt M_m X_n")
            ),
            definitions = listOf(
                "Le Chatelier's Principle" to "If a system at equilibrium is subjected to change of concentration, pressure or temperature, the equilibrium shifts in direction that tends to undo the effect of change.",
                "Buffer Solution" to "A solution that resists changes in pH upon addition of small amounts of acid or base."
            ),
            examples = listOf(
                SolvedExample(
                    question = "Calculate the pH of a 0.001 M HCl solution.",
                    solution = "HCl is a strong acid, dissociating completely:\n[H⁺] = 0.001 M = 10⁻³ M.\npH = -log₁₀[H⁺] = -log₁₀(10⁻³) = 3.",
                    keyStep = "Take negative logarithm of hydrogen ion concentration."
                )
            ),
            practiceQuestions = listOf(
                PracticeQuestion("For N₂(g) + 3H₂(g) ⇌ 2NH₃(g) + Heat, what happens if pressure is increased?", "Equilibrium shifts towards fewer moles of gas (forward)", "Ammonia yield increases")
            ),
            mcqs = listOf(
                McqQuestion("c6_1", "What is the pH of 10⁻⁸ M HCl solution?", listOf("8", "7", "Just below 7 (≈ 6.98)", "6"), 2, "Water auto-ionization [H⁺] = 10⁻⁷ M cannot be neglected. Total [H⁺] ≈ 1.1 × 10⁻⁷ M, pH ≈ 6.98.", "Equilibrium", SubjectType.CHEMISTRY)
            ),
            quickRevision = listOf(
                "Catalyst accelerates both forward and reverse rates equally without changing equilibrium position."
            )
        ),
        Chapter(
            id = "chem_ch7",
            number = 7,
            subject = SubjectType.CHEMISTRY,
            title = "Redox Reactions",
            overview = "Concept of oxidation and reduction, redox reactions, oxidation number, balancing redox reactions (oxidation number method and ion-electron method), and electrochemical cells.",
            keyPoints = listOf(
                "Oxidation: Loss of electrons (increase in oxidation state).",
                "Reduction: Gain of electrons (decrease in oxidation state).",
                "Oxidizing agent gets reduced; Reducing agent gets oxidized.",
                "Sum of oxidation states in neutral molecule is zero; in polyatomic ion equals charge on ion."
            ),
            formulas = listOf(
                FormulaItem("Oxidation Number Rules", "F is -1, O is usually -2 (-1 in peroxides), H is +1 (-1 in hydrides)", "Standard oxidation assignments"),
                FormulaItem("Standard Cell Potential", "E°_cell = E°_cathode - E°_anode", "Standard reduction potentials")
            ),
            definitions = listOf(
                "Disproportionation Reaction" to "A redox reaction in which the same element in one oxidation state is simultaneously oxidized and reduced."
            ),
            examples = listOf(
                SolvedExample(
                    question = "Find the oxidation number of Cr in K₂Cr₂O₇.",
                    solution = "Let oxidation state of Cr be x.\n2(+1) + 2(x) + 7(-2) = 0\n2 + 2x - 14 = 0  ⇒  2x = 12  ⇒  x = +6.",
                    keyStep = "Equate sum of oxidation numbers of all atoms to zero."
                )
            ),
            practiceQuestions = listOf(
                PracticeQuestion("Identify which element is oxidized in: 2Na + Cl₂ → 2NaCl.", "Na changes from 0 to +1 (loss of electrons)", "Sodium (Na) is oxidized")
            ),
            mcqs = listOf(
                McqQuestion("c7_1", "What is the oxidation state of Manganese in KMnO₄?", listOf("+2", "+4", "+6", "+7"), 3, "(+1) + Mn + 4(-2) = 0  ⇒  Mn = +7.", "Redox Reactions", SubjectType.CHEMISTRY)
            ),
            quickRevision = listOf(
                "In H₂O₂, Oxygen has oxidation state -1.",
                "Fluorine displays only -1 oxidation state in all its compounds."
            )
        ),
        Chapter(
            id = "chem_ch8",
            number = 8,
            subject = SubjectType.CHEMISTRY,
            title = "Organic Chemistry: Principles & Techniques",
            overview = "General introduction, methods of purification, qualitative and quantitative analysis, IUPAC nomenclature of organic compounds, inductive effect, electromeric effect, resonance, hyperconjugation, and reaction intermediates (carbocations, carbanions, free radicals).",
            keyPoints = listOf(
                "Carbon shows catenation and tetravalency due to small size and hybridization.",
                "Inductive effect (I): Polarization of σ-bond transmitted along carbon chain.",
                "Hyperconjugation (No-bond resonance): Overlap of σ C-H bond with empty p-orbital.",
                "Carbocation stability: 3° > 2° > 1° > methyl (stabilized by +I and hyperconjugation)."
            ),
            formulas = listOf(
                FormulaItem("Dumas Method for Nitrogen", "% N = (28 × V_N2 × 100) / (22400 × mass of organic compound)", "Quantitative elemental analysis"),
                FormulaItem("Kjeldahl's Method", "% N = (1.4 × M × V) / mass of compound", "M = molarity of acid, V = volume used")
            ),
            definitions = listOf(
                "Electrophile" to "Electron-seeking species that attacks electron-rich centers (e.g. H⁺, NO₂⁺, AlCl₃).",
                "Nucleophile" to "Electron-rich species that donates electron pair to electron-deficient centers (e.g. OH⁻, NH₃, CN⁻)."
            ),
            examples = listOf(
                SolvedExample(
                    question = "Give the IUPAC name for CH₃ - CH(CH₃) - CH₂ - CH₃.",
                    solution = "Longest continuous carbon chain has 4 carbons (butane).\nNumber from left to give methyl group lowest locant (2).\nIUPAC Name: 2-methylbutane.",
                    keyStep = "Find longest parent chain and assign lowest locant to substituent."
                )
            ),
            practiceQuestions = listOf(
                PracticeQuestion("Arrange carbocations (CH₃)₃C⁺, (CH₃)₂CH⁺, CH₃CH₂⁺ in increasing order of stability.", "Stability increases with more hyperconjugative structures and +I groups", "CH₃CH₂⁺ < (CH₃)₂CH⁺ < (CH₃)₃C⁺")
            ),
            mcqs = listOf(
                McqQuestion("c8_1", "Which of the following is an electrophile?", listOf("H₂O", "NH₃", "BF₃", "OH⁻"), 2, "BF₃ is electron deficient with an incomplete octet (6 valence electrons), acting as a Lewis acid / electrophile.", "Organic Chemistry", SubjectType.CHEMISTRY)
            ),
            quickRevision = listOf(
                "Homolytic fission generates neutral free radicals with odd electrons.",
                "Heterolytic fission generates charged carbocations and carbanions."
            )
        ),
        Chapter(
            id = "chem_ch9",
            number = 9,
            subject = SubjectType.CHEMISTRY,
            title = "Hydrocarbons",
            overview = "Classification of hydrocarbons: Alkanes (conformations of ethane), Alkenes (geometrical isomerism, Markovnikov's rule, ozonolysis), Alkynes (acidity of terminal alkynes), and Aromatic hydrocarbons (benzene, Huckel's rule of aromaticity, electrophilic aromatic substitution).",
            keyPoints = listOf(
                "Conformations of Ethane: Staggered conformation is more stable than eclipsed due to minimal torsional strain.",
                "Markovnikov's Rule: Negative part of addendum adds to carbon of double bond having fewer hydrogen atoms.",
                "Hückel's Rule of Aromaticity: Planar, cyclic, fully conjugated system with (4n + 2) π electrons is aromatic (e.g. benzene with 6 π electrons, n=1).",
                "Ozonolysis of alkenes cleaves C=C double bond, yielding aldehydes and ketones."
            ),
            formulas = listOf(
                FormulaItem("Hückel's Rule", "π electrons = 4n + 2 (where n = 0, 1, 2, ...)", "Criterion for aromaticity in planar cyclic conjugated systems"),
                FormulaItem("General Formula Alkanes", "CₙH₂ₙ₊₂", "Saturated acyclic hydrocarbons"),
                FormulaItem("General Formula Alkenes", "CₙH₂ₙ", "Hydrocarbons with one double bond"),
                FormulaItem("General Formula Alkynes", "CₙH₂ₙ₋₂", "Hydrocarbons with one triple bond")
            ),
            definitions = listOf(
                "Aromaticity" to "Special chemical stability possessed by cyclic planar compounds following Hückel's (4n + 2) π electron rule.",
                "Markovnikov's Rule" to "In electrophilic addition of an unsymmetrical reagent to an unsymmetrical alkene, the positive hydrogen adds to carbon with more hydrogens."
            ),
            examples = listOf(
                SolvedExample(
                    question = "What products are formed upon ozonolysis of 2-butene (CH₃-CH=CH-CH₃) followed by Zn/H₂O?",
                    solution = "The double bond cleaves completely with oxygen attached to each carbon:\nCH₃-CH=CH-CH₃ + O₃ / Zn, H₂O  →  2 moles of Acetaldehyde (CH₃CHO).",
                    keyStep = "Cleave C=C bond and cap each fragment with =O."
                )
            ),
            practiceQuestions = listOf(
                PracticeQuestion("Why are terminal alkynes like ethyne acidic in nature?", "Terminal C-H carbon is sp-hybridized with 50% s-character and high electronegativity", "Readily releases H⁺ to strong bases like NaNH₂")
            ),
            mcqs = listOf(
                McqQuestion("c9_1", "How many π electrons does Benzene have according to Hückel's rule?", listOf("2", "4", "6", "8"), 2, "Benzene has three alternating double bonds containing 6 π electrons (4(1) + 2 = 6).", "Hydrocarbons", SubjectType.CHEMISTRY)
            ),
            quickRevision = listOf(
                "Staggered conformation of ethane is 12.5 kJ/mol lower in energy than eclipsed.",
                "Anti-Markovnikov addition (Peroxide effect) occurs exclusively with HBr."
            )
        )
    )
}
