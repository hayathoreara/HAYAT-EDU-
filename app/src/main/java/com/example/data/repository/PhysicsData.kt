package com.example.data.repository

import com.example.data.model.*

object PhysicsData {
    val chapters: List<Chapter> = listOf(
        Chapter(
            id = "phy_ch1",
            number = 1,
            subject = SubjectType.PHYSICS,
            title = "Units and Measurements",
            overview = "The international system of units (SI), measurement of length, mass, and time, accuracy and precision, errors in measurement, and dimensional analysis.",
            keyPoints = listOf(
                "Fundamental SI units: meter (m), kilogram (kg), second (s), ampere (A), kelvin (K), mole (mol), candela (cd).",
                "Principle of Homogeneity: Dimensions of all terms on both sides of a physical equation must be identical.",
                "Significant figures determine the precision of measurement."
            ),
            formulas = listOf(
                FormulaItem("Percentage Error", "% Error = (Δa / a_mean) × 100", "Relative error expressed as %"),
                FormulaItem("Force Dimension", "[F] = [M L T⁻²]", "SI unit: Newton (N) = kg·m/s²", "Newton (N)", "[M L T⁻²]"),
                FormulaItem("Energy/Work Dimension", "[W] = [M L² T⁻²]", "SI unit: Joule (J) = N·m", "Joule (J)", "[M L² T⁻²]"),
                FormulaItem("Pressure Dimension", "[P] = [M L⁻¹ T⁻²]", "SI unit: Pascal (Pa) = N/m²", "Pascal (Pa)", "[M L⁻¹ T⁻²]")
            ),
            definitions = listOf(
                "Accuracy" to "Measure of how close the measured value is to the true value.",
                "Precision" to "Measure of the resolution or closeness of multiple repeated measurements."
            ),
            examples = listOf(
                SolvedExample(
                    question = "Check the dimensional correctness of the equation v² = u² + 2as.",
                    solution = "[v²] = [L T⁻¹]² = [L² T⁻²]\n[u²] = [L² T⁻²]\n[2as] = [L T⁻²][L] = [L² T⁻²]\nAll terms have identical dimensions [L² T⁻²], hence the equation is dimensionally consistent.",
                    keyStep = "Check dimensions of LHS and every term of RHS independently."
                )
            ),
            practiceQuestions = listOf(
                PracticeQuestion("Find the dimensions of Universal Gravitational Constant G.", "From F = G m₁m₂ / r²  ⇒  G = F r² / m²", "[M⁻¹ L³ T⁻²]")
            ),
            mcqs = listOf(
                McqQuestion("p1_1", "Which of the following physical quantities has the dimensions [M L² T⁻³]?", listOf("Work", "Power", "Force", "Pressure"), 1, "Power = Work / Time = [M L² T⁻²] / [T] = [M L² T⁻³].", "Units and Measurements", SubjectType.PHYSICS),
                McqQuestion("p1_2", "How many significant figures are in 0.002040?", listOf("3", "4", "6", "7"), 1, "Leading zeros are not significant; digits 2, 0, 4, 0 give 4 significant figures.", "Units and Measurements", SubjectType.PHYSICS)
            ),
            quickRevision = listOf(
                "Angle (radian) and Solid Angle (steradian) are supplementary dimensionless quantities with units.",
                "Constants like π, e, and pure numbers are dimensionless."
            )
        ),
        Chapter(
            id = "phy_ch2",
            number = 2,
            subject = SubjectType.PHYSICS,
            title = "Motion in a Straight Line",
            overview = "Position, path length, displacement, average velocity, instantaneous speed and velocity, acceleration, and kinematic equations for uniformly accelerated motion.",
            keyPoints = listOf(
                "Distance is scalar (path length); displacement is vector (shortest distance between initial and final points).",
                "Instantaneous velocity v = dx/dt, acceleration a = dv/dt = d²x/dt².",
                "Area under v-t graph represents displacement. Slope of v-t graph represents acceleration."
            ),
            formulas = listOf(
                FormulaItem("Velocity-Time Relation", "v = u + at", "First equation of motion", "m/s", "[L T⁻¹]"),
                FormulaItem("Displacement-Time", "s = ut + (1/2)at²", "Second equation of motion", "meter (m)", "[L]"),
                FormulaItem("Velocity-Displacement", "v² = u² + 2as", "Third equation of motion", "m²/s²", "[L² T⁻²]"),
                FormulaItem("Displacement in n-th Second", "sₙ = u + (a/2)(2n - 1)", "Distance covered strictly in the n-th second", "meter (m)", "[L]")
            ),
            definitions = listOf(
                "Instantaneous Velocity" to "The limit of average velocity as the time interval Δt approaches zero (dx/dt).",
                "Free Fall" to "Motion of an object under the sole influence of gravity with acceleration g ≈ 9.8 m/s² downwards."
            ),
            examples = listOf(
                SolvedExample(
                    question = "A car traveling at 20 m/s is brought to rest in 5 seconds by applying brakes. Find the deceleration and stopping distance.",
                    solution = "u = 20 m/s, v = 0, t = 5 s.\nv = u + at  ⇒  0 = 20 + a(5)  ⇒  a = -4 m/s² (deceleration = 4 m/s²).\ns = ut + 1/2 at² = 20(5) + 1/2(-4)(25) = 100 - 50 = 50 m.",
                    keyStep = "Use v = u + at to find a, then s = ut + 1/2 at² for distance."
                )
            ),
            practiceQuestions = listOf(
                PracticeQuestion("A ball is thrown vertically upward with speed 19.6 m/s. How high does it rise before stopping?", "v = 0, g = -9.8 m/s², use v² = u² + 2gh", "19.6 meters")
            ),
            mcqs = listOf(
                McqQuestion("p2_1", "What does the slope of a position-time graph represent?", listOf("Acceleration", "Velocity", "Distance", "Force"), 1, "Slope dx/dt represents instantaneous velocity.", "Motion in a Straight Line", SubjectType.PHYSICS)
            ),
            quickRevision = listOf(
                "For free fall from rest: v = gt, h = 1/2 gt².",
                "Time of ascent equals time of descent in the absence of air resistance."
            )
        ),
        Chapter(
            id = "phy_ch3",
            number = 3,
            subject = SubjectType.PHYSICS,
            title = "Motion in a Plane",
            overview = "Scalars and vectors, vector addition, resolution of vectors, projectile motion, and uniform circular motion.",
            keyPoints = listOf(
                "Vectors have magnitude and direction, following vector addition laws (Triangle & Parallelogram laws).",
                "Dot product: A · B = |A||B| cos θ (scalar). Cross product: A × B = |A||B| sin θ n̂ (vector).",
                "Projectile motion is 2D motion with constant downward acceleration g and constant horizontal velocity."
            ),
            formulas = listOf(
                FormulaItem("Time of Flight", "T = (2u sin θ) / g", "Total time in air", "seconds (s)", "[T]"),
                FormulaItem("Maximum Height", "H_max = (u² sin²θ) / (2g)", "Highest altitude reached", "meter (m)", "[L]"),
                FormulaItem("Horizontal Range", "R = (u² sin 2θ) / g", "Maximum range at θ = 45°: R_max = u²/g", "meter (m)", "[L]"),
                FormulaItem("Centripetal Acceleration", "a_c = v² / r = ω² r", "Directed toward center of circular path", "m/s²", "[L T⁻²]")
            ),
            definitions = listOf(
                "Centripetal Acceleration" to "The radial acceleration of an object moving in a circular path directed towards the center.",
                "Unit Vector" to "A vector of unit magnitude: â = A / |A|."
            ),
            examples = listOf(
                SolvedExample(
                    question = "A projectile is fired at an angle of 30° with initial speed 40 m/s. Find the maximum height reached (take g = 10 m/s²).",
                    solution = "H = (u² sin²θ) / (2g) = (40² × sin² 30°) / (2 × 10)\n= (1600 × (1/2)²) / 20 = (1600 × 1/4) / 20 = 400 / 20 = 20 m.",
                    keyStep = "Substitute values into H_max formula."
                )
            ),
            practiceQuestions = listOf(
                PracticeQuestion("At what angle of projection is the horizontal range equal to the maximum height?", "R = H  ⇒  (u² sin 2θ)/g = (u² sin²θ)/(2g)", "tan θ = 4  ⇒  θ = arctan(4) ≈ 76°")
            ),
            mcqs = listOf(
                McqQuestion("p3_1", "At the highest point of projectile trajectory, the angle between velocity and acceleration is:", listOf("0°", "45°", "90°", "180°"), 2, "Velocity is purely horizontal while acceleration g is vertically downward, making a 90° angle.", "Motion in a Plane", SubjectType.PHYSICS)
            ),
            quickRevision = listOf(
                "Horizontal velocity remains constant throughout projectile flight.",
                "Range is identical for complementary projection angles: θ and (90° - θ)."
            )
        ),
        Chapter(
            id = "phy_ch4",
            number = 4,
            subject = SubjectType.PHYSICS,
            title = "Laws of Motion",
            overview = "Intuitive concept of force, inertia, Newton's three laws of motion, momentum, impulse, conservation of linear momentum, and friction.",
            keyPoints = listOf(
                "First Law (Inertia): A body remains at rest or in uniform motion unless acted on by net external force.",
                "Second Law: F_net = dp/dt = m·a (rate of change of linear momentum).",
                "Third Law: For every action, there is an equal and opposite reaction.",
                "Friction f_s ≤ μ_s N (static), f_k = μ_k N (kinetic). Rolling friction < kinetic < static."
            ),
            formulas = listOf(
                FormulaItem("Newton's 2nd Law", "F = m · a", "Net force equals mass times acceleration", "Newton (N)", "[M L T⁻²]"),
                FormulaItem("Impulse", "J = F · Δt = Δp = m(v - u)", "Change in momentum", "N·s or kg·m/s", "[M L T⁻¹]"),
                FormulaItem("Static Friction Max", "f_s(max) = μ_s · N", "Limiting friction", "Newton (N)", "[M L T⁻²]"),
                FormulaItem("Maximum Safe Speed on Banked Curve", "v_max = √[ r·g (tan θ + μ) / (1 - μ tan θ) ]", "For road of radius r with banking θ", "m/s", "[L T⁻¹]")
            ),
            definitions = listOf(
                "Impulse" to "The product of average force and the brief duration over which it acts, equal to change in momentum.",
                "Limiting Friction" to "The maximum value of static friction before relative motion begins."
            ),
            examples = listOf(
                SolvedExample(
                    question = "A force of 10 N acts on a body of mass 2 kg initially at rest for 3 seconds. Find its final velocity.",
                    solution = "a = F / m = 10 / 2 = 5 m/s².\nv = u + at = 0 + 5(3) = 15 m/s.",
                    keyStep = "Find acceleration from F=ma then apply kinematics."
                )
            ),
            practiceQuestions = listOf(
                PracticeQuestion("Why is a curved highway banked?", "To provide necessary centripetal force from normal reaction", "Reduces reliance on tire friction")
            ),
            mcqs = listOf(
                McqQuestion("p4_1", "Rocket propulsion is based on the principle of conservation of:", listOf("Mass", "Energy", "Linear Momentum", "Angular Momentum"), 2, "Ejection of exhaust gases propels rocket forward by conservation of linear momentum.", "Laws of Motion", SubjectType.PHYSICS)
            ),
            quickRevision = listOf(
                "Action and reaction act on two different bodies and never cancel each other."
            )
        ),
        Chapter(
            id = "phy_ch5",
            number = 5,
            subject = SubjectType.PHYSICS,
            title = "Work, Energy and Power",
            overview = "Work done by constant and variable forces, kinetic energy, work-energy theorem, potential energy, conservation of mechanical energy, and collisions.",
            keyPoints = listOf(
                "Work W = F · s = F s cos θ. No work is done when force is perpendicular to displacement (θ = 90°).",
                "Work-Energy Theorem: Total work done by all forces equals change in kinetic energy: W = ΔK.",
                "Conservative forces: Work done depends only on endpoints, not on path taken (e.g. Gravity, Electrostatic).",
                "In elastic collisions, both kinetic energy and linear momentum are conserved."
            ),
            formulas = listOf(
                FormulaItem("Work", "W = F · d · cos θ", "Scalar product of force and displacement", "Joule (J)", "[M L² T⁻²]"),
                FormulaItem("Kinetic Energy", "K = (1/2) m v² = p² / (2m)", "Energy possessed due to motion", "Joule (J)", "[M L² T⁻²]"),
                FormulaItem("Spring Potential Energy", "U = (1/2) k x²", "k is spring constant, x is deformation", "Joule (J)", "[M L² T⁻²]"),
                FormulaItem("Power", "P = dW/dt = F · v", "Rate of doing work", "Watt (W)", "[M L² T⁻³]")
            ),
            definitions = listOf(
                "Conservative Force" to "A force for which work done along any closed path is zero (∮ F · dr = 0).",
                "Power" to "The rate at which work is done or energy is transferred."
            ),
            examples = listOf(
                SolvedExample(
                    question = "A body of mass 5 kg moves with velocity changing from 2 m/s to 4 m/s. Find the work done on it.",
                    solution = "W = ΔK = 1/2 m (v² - u²) = 1/2 (5) (4² - 2²) = 2.5 (16 - 4) = 2.5 × 12 = 30 J.",
                    keyStep = "Use Work-Energy Theorem W = ΔK."
                )
            ),
            practiceQuestions = listOf(
                PracticeQuestion("If momentum of a body increases by 50%, find the percentage increase in its kinetic energy.", "K ∝ p². New K = (1.5 p)² = 2.25 K", "125% increase")
            ),
            mcqs = listOf(
                McqQuestion("p5_1", "What is the work done by centripetal force on an object moving in a circle?", listOf("Positive", "Negative", "Zero", "Depends on radius"), 2, "Centripetal force is always perpendicular to instantaneous displacement (cos 90° = 0).", "Work, Energy and Power", SubjectType.PHYSICS)
            ),
            quickRevision = listOf(
                "1 Horsepower (HP) = 746 Watts.",
                "In an inelastic collision, momentum is conserved but mechanical kinetic energy is not."
            )
        ),
        Chapter(
            id = "phy_ch6",
            number = 6,
            subject = SubjectType.PHYSICS,
            title = "System of Particles & Rotational Motion",
            overview = "Center of mass, torque, angular momentum, conservation of angular momentum, moment of inertia, and rolling motion.",
            keyPoints = listOf(
                "Center of Mass R_cm = (Σ mᵢ rᵢ) / (Σ mᵢ).",
                "Torque τ = r × F = I · α (rotational analog of force).",
                "Angular Momentum L = r × p = I · ω. In absence of external torque, L is conserved.",
                "Moment of Inertia I = Σ mᵢ rᵢ² = M k² (k is radius of gyration)."
            ),
            formulas = listOf(
                FormulaItem("Torque", "τ = r × F = I · α", "Rotational force", "N·m", "[M L² T⁻²]"),
                FormulaItem("Angular Momentum", "L = I · ω", "Rotational momentum", "kg·m²/s", "[M L² T⁻¹]"),
                FormulaItem("Rotational Kinetic Energy", "K_rot = (1/2) I ω²", "Energy of spinning body", "Joule (J)", "[M L² T⁻²]"),
                FormulaItem("Parallel Axis Theorem", "I = I_cm + M d²", "d is perpendicular distance between axes", "kg·m²", "[M L²]")
            ),
            definitions = listOf(
                "Center of Mass" to "A point where the entire mass of a system of particles may be supposed to be concentrated.",
                "Radius of Gyration" to "The radial distance from axis of rotation at which total mass can be concentrated without changing moment of inertia."
            ),
            examples = listOf(
                SolvedExample(
                    question = "A solid cylinder of mass 2 kg and radius 0.2 m rotates about its central axis. Find its moment of inertia.",
                    solution = "I = (1/2) M R² = 0.5 × 2 × (0.2)² = 1 × 0.04 = 0.04 kg·m².",
                    keyStep = "Formula for solid cylinder about axis is 1/2 M R²."
                )
            ),
            practiceQuestions = listOf(
                PracticeQuestion("Why does a ballet dancer fold her arms while performing spins on ice?", "Folding arms reduces radius, lowering I, thus increasing angular speed ω", "Conservation of angular momentum (I₁ω₁ = I₂ω₂)")
            ),
            mcqs = listOf(
                McqQuestion("p6_1", "What is the moment of inertia of a uniform circular ring of mass M and radius R about its central axis?", listOf("1/2 M R²", "M R²", "2/5 M R²", "2/3 M R²"), 1, "All mass is at distance R from axis, so I = M R².", "Rotational Motion", SubjectType.PHYSICS)
            ),
            quickRevision = listOf(
                "Linear motion vs Rotational: mass m ↔ moment of inertia I, force F ↔ torque τ, v ↔ ω."
            )
        ),
        Chapter(
            id = "phy_ch7",
            number = 7,
            subject = SubjectType.PHYSICS,
            title = "Gravitation",
            overview = "Kepler's laws of planetary motion, Universal law of gravitation, acceleration due to gravity g and its variation, gravitational potential energy, and escape velocity.",
            keyPoints = listOf(
                "Kepler's Laws: 1) Elliptical orbits, 2) Equal areas in equal intervals of time (dA/dt = L/2m = constant), 3) T² ∝ a³.",
                "Universal Gravitation: F = G m₁ m₂ / r² with G = 6.674 × 10⁻¹¹ N·m²/kg².",
                "Acceleration due to gravity: g = G M / R². Decreases with height and depth.",
                "Escape velocity from Earth: v_e = √(2 g R) ≈ 11.2 km/s."
            ),
            formulas = listOf(
                FormulaItem("Gravitational Force", "F = G · (m₁ · m₂) / r²", "Universal inverse square law", "Newton (N)", "[M L T⁻²]"),
                FormulaItem("Gravity with Altitude", "g_h = g · (1 - 2h/R)", "For altitude h << R", "m/s²", "[L T⁻²]"),
                FormulaItem("Gravity with Depth", "g_d = g · (1 - d/R)", "At depth d below surface", "m/s²", "[L T⁻²]"),
                FormulaItem("Escape Velocity", "v_e = √(2 G M / R) = √(2 g R)", "Minimum speed to escape gravitational pull", "m/s", "[L T⁻¹]"),
                FormulaItem("Orbital Velocity", "v_o = √(G M / R) = √(g R)", "Satellite in low Earth orbit ≈ 7.9 km/s", "m/s", "[L T⁻¹]")
            ),
            definitions = listOf(
                "Escape Velocity" to "The minimum speed required for a body to break free from the gravitational pull of a celestial body.",
                "Gravitational Potential" to "Work done in bringing a unit mass from infinity to that point in a gravitational field."
            ),
            examples = listOf(
                SolvedExample(
                    question = "What is the value of acceleration due to gravity at the center of the Earth?",
                    solution = "At center, depth d = R.\ng_d = g(1 - d/R) = g(1 - R/R) = g(0) = 0 m/s².",
                    keyStep = "At center of uniform sphere, gravitational field is zero."
                )
            ),
            practiceQuestions = listOf(
                PracticeQuestion("What is the ratio of escape velocity to orbital velocity for a low Earth satellite?", "v_e / v_o = √(2 g R) / √(g R)", "√2 ≈ 1.414")
            ),
            mcqs = listOf(
                McqQuestion("p7_1", "Kepler's second law regarding areal velocity is a consequence of conservation of:", listOf("Linear momentum", "Angular momentum", "Energy", "Mass"), 1, "Gravitational force is a central force producing zero torque, conserving angular momentum.", "Gravitation", SubjectType.PHYSICS)
            ),
            quickRevision = listOf(
                "v_e = √2 · v_o.",
                "Weightlessness in orbit occurs because satellite and occupant are in continuous free fall."
            )
        ),
        Chapter(
            id = "phy_ch8",
            number = 8,
            subject = SubjectType.PHYSICS,
            title = "Mechanical Properties of Solids",
            overview = "Elastic behavior, stress and strain, Hooke's law, stress-strain curve, Young's modulus, bulk modulus, shear modulus, and Poisson's ratio.",
            keyPoints = listOf(
                "Hooke's Law: Within elastic limit, Stress ∝ Strain (Stress / Strain = Modulus of Elasticity).",
                "Young's Modulus Y = (F / A) / (ΔL / L) (for tensile/compressive deformation).",
                "Bulk Modulus B = -ΔP / (ΔV / V). Compressibility k = 1 / B.",
                "Steel is more elastic than rubber because it requires much greater stress for the same strain."
            ),
            formulas = listOf(
                FormulaItem("Young's Modulus", "Y = (F · L) / (A · ΔL)", "Longitudinal elasticity", "N/m² or Pa", "[M L⁻¹ T⁻²]"),
                FormulaItem("Bulk Modulus", "B = -V · (ΔP / ΔV)", "Volumetric elasticity", "Pascal (Pa)", "[M L⁻¹ T⁻²]"),
                FormulaItem("Elastic Potential Energy per Unit Volume", "u = (1/2) × Stress × Strain", "Strain energy density", "J/m³", "[M L⁻¹ T⁻²]")
            ),
            definitions = listOf(
                "Elasticity" to "The property of a body by virtue of which it regains its original shape and size after deforming forces are removed.",
                "Yield Point" to "The point on the stress-strain curve beyond which plastic deformation begins."
            ),
            examples = listOf(
                SolvedExample(
                    question = "A steel wire of length 2 m and cross-section 1 mm² is stretched by 2 mm with a force of 200 N. Find Young's modulus.",
                    solution = "F = 200 N, L = 2 m, A = 10⁻⁶ m², ΔL = 2 × 10⁻³ m.\nY = (F · L) / (A · ΔL) = (200 × 2) / (10⁻⁶ × 2 × 10⁻³) = 400 / (2 × 10⁻⁹) = 2 × 10¹¹ N/m².",
                    keyStep = "Convert all values strictly into SI units before calculation."
                )
            ),
            practiceQuestions = listOf(
                PracticeQuestion("Which material is more elastic: steel or rubber?", "Stress required for same strain is much larger in steel", "Steel")
            ),
            mcqs = listOf(
                McqQuestion("p8_1", "What are the dimensions of modulus of elasticity?", listOf("[M L T⁻²]", "[M L⁻¹ T⁻²]", "[M L² T⁻²]", "Dimensionless"), 1, "Modulus = Stress / Strain = (F/A) / dimensionless = [M L⁻¹ T⁻²].", "Mechanical Properties of Solids", SubjectType.PHYSICS)
            ),
            quickRevision = listOf(
                "Strain is dimensionless.",
                "Breaking stress is an intrinsic material property and does not depend on wire length."
            )
        ),
        Chapter(
            id = "phy_ch9",
            number = 9,
            subject = SubjectType.PHYSICS,
            title = "Mechanical Properties of Fluids",
            overview = "Pressure in fluids, Pascal's law, Archimedes' principle, streamline and turbulent flow, equation of continuity, Bernoulli's principle, viscosity, and surface tension.",
            keyPoints = listOf(
                "Pascal's Principle: Pressure applied to an enclosed fluid is transmitted undiminished in all directions.",
                "Continuity Equation: A₁ v₁ = A₂ v₂ (Conservation of Mass in incompressible flow).",
                "Bernoulli's Principle: P + (1/2) ρ v² + ρ g h = constant (Conservation of Energy in ideal fluid).",
                "Viscous force F = -η A (dv/dx). Stokes' law for terminal velocity: F = 6πηrv."
            ),
            formulas = listOf(
                FormulaItem("Gauge Pressure", "P = P₀ + ρ · g · h", "Pressure at depth h", "Pascal (Pa)", "[M L⁻¹ T⁻²]"),
                FormulaItem("Bernoulli's Equation", "P + (1/2)ρv² + ρgh = const", "Total mechanical energy of flowing fluid", "Pascal (Pa)", "[M L⁻¹ T⁻²]"),
                FormulaItem("Terminal Velocity", "v_t = 2 r² (ρ - σ) g / (9 η)", "Constant speed reached falling in viscous fluid", "m/s", "[L T⁻¹]"),
                FormulaItem("Surface Tension Excess Pressure (Bubble)", "ΔP = 4T / R", "For soap bubble with two surfaces", "Pascal (Pa)", "[M L⁻¹ T⁻²]")
            ),
            definitions = listOf(
                "Surface Tension" to "Force per unit length acting in the plane of the interface between liquid and other medium (T = F / L).",
                "Viscosity" to "Internal frictional resistance offered by fluid layers to relative motion."
            ),
            examples = listOf(
                SolvedExample(
                    question = "Water flows through a pipe of diameter 4 cm with speed 2 m/s. What is the speed where diameter constricts to 2 cm?",
                    solution = "A₁ v₁ = A₂ v₂  ⇒  (π d₁²/4) v₁ = (π d₂²/4) v₂\nd₁² v₁ = d₂² v₂  ⇒  (4)² (2) = (2)² v₂  ⇒  16 × 2 = 4 × v₂  ⇒  v₂ = 8 m/s.",
                    keyStep = "Velocity is inversely proportional to square of diameter."
                )
            ),
            practiceQuestions = listOf(
                PracticeQuestion("Why do airplane wings generate aerodynamic lift?", "Wing curved top creates higher velocity air, lowering pressure above wing by Bernoulli's principle", "Dynamic lift produced by pressure difference")
            ),
            mcqs = listOf(
                McqQuestion("p9_1", "What is the excess pressure inside an air bubble of radius R immersed in water of surface tension T?", listOf("T / R", "2T / R", "4T / R", "8T / R"), 1, "An air bubble in water has only one liquid-air interface, so ΔP = 2T / R.", "Mechanical Properties of Fluids", SubjectType.PHYSICS)
            ),
            quickRevision = listOf(
                "Raindrops acquire constant terminal velocity due to air viscosity."
            )
        ),
        Chapter(
            id = "phy_ch10",
            number = 10,
            subject = SubjectType.PHYSICS,
            title = "Thermal Properties of Matter",
            overview = "Heat and temperature, thermal expansion, specific heat capacity, calorimetry, latent heat, and heat transfer mechanisms (conduction, convection, radiation).",
            keyPoints = listOf(
                "Thermal expansion relations: β = 2α (areal) and γ = 3α (volumetric) for isotropic solids.",
                "Heat transfer Q = m · c · ΔT (sensible heat) and Q = m · L (latent heat during phase change).",
                "Newton's Law of Cooling: Rate of cooling is proportional to temperature difference between body and surroundings.",
                "Wien's Displacement Law: λ_max · T = b = 2.898 × 10⁻³ m·K."
            ),
            formulas = listOf(
                FormulaItem("Linear Expansion", "ΔL = L₀ · α · ΔT", "α is coefficient of linear expansion", "meter (m)", "[L]"),
                FormulaItem("Stefan-Boltzmann Law", "E = e · σ · T⁴", "σ = 5.67 × 10⁻⁸ W/(m²·K⁴)", "W/m²", "[M T⁻³]"),
                FormulaItem("Wien's Displacement Law", "λ_max · T = b", "Constant b ≈ 2.898 × 10⁻³ m·K", "m·K", "[L K]")
            ),
            definitions = listOf(
                "Specific Heat Capacity" to "Amount of heat energy required to raise temperature of unit mass by 1 Kelvin (or 1 °C).",
                "Latent Heat" to "Heat absorbed or released during phase transition without temperature change."
            ),
            examples = listOf(
                SolvedExample(
                    question = "How much heat is required to raise the temperature of 2 kg of water from 20 °C to 70 °C? (c_water = 4200 J/kg·K).",
                    solution = "Q = m c ΔT = 2 × 4200 × (70 - 20) = 8400 × 50 = 420,000 J = 420 kJ.",
                    keyStep = "Use Q = m c ΔT."
                )
            ),
            practiceQuestions = listOf(
                PracticeQuestion("State the relationship between linear expansion coefficient α and volumetric expansion coefficient γ.", "γ = 3α", "For isotropic solid: γ = 3α")
            ),
            mcqs = listOf(
                McqQuestion("p10_1", "At what temperature do Fahrenheit and Celsius scales give the exact same numerical reading?", listOf("0°", "-40°", "100°", "-273°"), 1, "F = 9/5 C + 32  ⇒  x = 9/5 x + 32  ⇒  -4/5 x = 32  ⇒  x = -40°.", "Thermal Properties of Matter", SubjectType.PHYSICS)
            ),
            quickRevision = listOf(
                "Water exhibits anomalous expansion between 0 °C and 4 °C, having maximum density at 4 °C."
            )
        ),
        Chapter(
            id = "phy_ch11",
            number = 11,
            subject = SubjectType.PHYSICS,
            title = "Thermodynamics",
            overview = "Thermal equilibrium, Zeroth law of thermodynamics, First law (internal energy and work), Second law (Kelvin-Planck and Clausius statements), and Carnot cycle.",
            keyPoints = listOf(
                "Zeroth Law defines concept of Temperature.",
                "First Law (Energy Conservation): ΔQ = ΔU + ΔW, where ΔW = P ΔV.",
                "Isothermal process: T = const (ΔU = 0, Q = W). Adiabatic process: Q = 0 (ΔU = -W, P V^γ = const).",
                "Carnot engine efficiency: η = 1 - (T₂ / T₁) (theoretical maximum efficiency)."
            ),
            formulas = listOf(
                FormulaItem("First Law of Thermodynamics", "ΔQ = ΔU + ΔW", "Conservation of thermal energy", "Joule (J)", "[M L² T⁻²]"),
                FormulaItem("Work in Isothermal Process", "W = n R T ln(V₂ / V₁)", "Constant temperature expansion", "Joule (J)", "[M L² T⁻²]"),
                FormulaItem("Adiabatic Relation", "P · V^γ = constant", "γ = C_p / C_v", "-", "-"),
                FormulaItem("Carnot Efficiency", "η = 1 - T_cold / T_hot", "T must be in Kelvin", "Dimensionless", "-")
            ),
            definitions = listOf(
                "Adiabatic Process" to "A thermodynamic process in which no heat enters or leaves the system (Q = 0).",
                "Carnot Engine" to "An ideal reversible heat engine operating between two thermal reservoirs."
            ),
            examples = listOf(
                SolvedExample(
                    question = "A heat engine absorbs 500 J of heat from a reservoir at 500 K and rejects 300 J to a sink at 300 K. What is its efficiency?",
                    solution = "η = 1 - (Q₂ / Q₁) = 1 - (300 / 500) = 1 - 0.6 = 0.4 = 40%.",
                    keyStep = "Efficiency equals (Work Done / Heat In) = 1 - Q_out/Q_in."
                )
            ),
            practiceQuestions = listOf(
                PracticeQuestion("In an isobaric process, what physical variable remains constant?", "Isobaric means constant pressure", "Pressure (P = constant)")
            ),
            mcqs = listOf(
                McqQuestion("p11_1", "In an adiabatic expansion of an ideal gas, the internal energy of the gas:", listOf("Increases", "Decreases", "Remains constant", "Becomes zero"), 1, "Q = 0  ⇒  ΔU = -W. Work done by gas is positive, so ΔU is negative (decreases).", "Thermodynamics", SubjectType.PHYSICS)
            ),
            quickRevision = listOf(
                "ΔU depends solely on initial and final temperatures, being a state function."
            )
        ),
        Chapter(
            id = "phy_ch12",
            number = 12,
            subject = SubjectType.PHYSICS,
            title = "Kinetic Theory",
            overview = "Molecular nature of matter, ideal gas equation, pressure of an ideal gas, kinetic interpretation of temperature, degrees of freedom, and equipartition theorem.",
            keyPoints = listOf(
                "Ideal gas law: P V = n R T = N k_B T, where k_B = 1.38 × 10⁻²³ J/K.",
                "Kinetic pressure: P = (1/3) ρ v_rms².",
                "Law of Equipartition of Energy: Each degree of freedom contributes (1/2) k_B T to average energy of a molecule.",
                "Mean free path: λ = 1 / (√2 n π d²)."
            ),
            formulas = listOf(
                FormulaItem("RMS Speed", "v_rms = √(3 R T / M) = √(3 k_B T / m)", "Root-mean-square molecular speed", "m/s", "[L T⁻¹]"),
                FormulaItem("Average Kinetic Energy per Molecule", "E_avg = (3/2) k_B T", "Directly proportional to absolute temperature", "Joule (J)", "[M L² T⁻²]"),
                FormulaItem("Molar Heat Capacity Ratio", "γ = C_p / C_v = 1 + 2/f", "f = degrees of freedom", "-", "-")
            ),
            definitions = listOf(
                "Mean Free Path" to "The average distance traversed by a molecule between successive collisions.",
                "Degrees of Freedom" to "Number of independent coordinates needed to describe the motion and position of a molecule."
            ),
            examples = listOf(
                SolvedExample(
                    question = "At what temperature will the rms speed of oxygen gas molecules be double its value at 27 °C?",
                    solution = "T₁ = 27 + 273 = 300 K.\nv_rms ∝ √T  ⇒  v₂ / v₁ = √(T₂ / T₁) = 2  ⇒  T₂ / T₁ = 4\nT₂ = 4 × 300 = 1200 K = 927 °C.",
                    keyStep = "Convert temperatures strictly to absolute Kelvin scale first."
                )
            ),
            practiceQuestions = listOf(
                PracticeQuestion("What are the degrees of freedom for a monoatomic gas like Helium?", "Translational in 3 spatial axes", "3 degrees of freedom")
            ),
            mcqs = listOf(
                McqQuestion("p12_1", "What is the ratio γ = C_p / C_v for a monoatomic ideal gas?", listOf("1.33 (4/3)", "1.40 (7/5)", "1.67 (5/3)", "2.0"), 2, "f = 3  ⇒  γ = 1 + 2/3 = 5/3 ≈ 1.67.", "Kinetic Theory", SubjectType.PHYSICS)
            ),
            quickRevision = listOf(
                "At absolute zero (0 K), ideal gas molecular kinetic energy ceases."
            )
        ),
        Chapter(
            id = "phy_ch13",
            number = 13,
            subject = SubjectType.PHYSICS,
            title = "Oscillations",
            overview = "Periodic and oscillatory motion, simple harmonic motion (SHM), equation of SHM, velocity and acceleration, energy in SHM, and simple pendulum.",
            keyPoints = listOf(
                "SHM Condition: Restoring force is directly proportional to displacement and directed towards equilibrium: F = -k x.",
                "Displacement x = A sin(ωt + φ), velocity v = A ω cos(ωt + φ), acceleration a = -ω² x.",
                "Total energy in SHM is conserved: E = 1/2 m ω² A² = 1/2 k A².",
                "Simple pendulum period T = 2π √(L / g), independent of mass of bob."
            ),
            formulas = listOf(
                FormulaItem("SHM Acceleration", "a = -ω² · x", "Acceleration proportional to negative displacement", "m/s²", "[L T⁻²]"),
                FormulaItem("Simple Pendulum Period", "T = 2π √(L / g)", "L is pendulum length", "seconds (s)", "[T]"),
                FormulaItem("Spring-Mass Period", "T = 2π √(m / k)", "k is spring constant", "seconds (s)", "[T]"),
                FormulaItem("Total Energy in SHM", "E = (1/2) k A²", "Sum of kinetic and potential energy", "Joule (J)", "[M L² T⁻²]")
            ),
            definitions = listOf(
                "Simple Harmonic Motion" to "Oscillatory motion where restoring force is proportional to displacement from mean position and acts towards it.",
                "Resonance" to "Phenomenon where driving frequency matches natural frequency of oscillator, producing maximum amplitude."
            ),
            examples = listOf(
                SolvedExample(
                    question = "A particle executes SHM with amplitude 5 cm and time period 2 s. Find its maximum velocity.",
                    solution = "A = 0.05 m, T = 2 s.\nω = 2π / T = 2π / 2 = π rad/s.\nv_max = A ω = 0.05 × π ≈ 0.157 m/s.",
                    keyStep = "Maximum velocity occurs at mean position: v_max = A ω."
                )
            ),
            practiceQuestions = listOf(
                PracticeQuestion("What happens to the time period of a simple pendulum if its length is quadrupled?", "T ∝ √L, so new T' = √4 T", "Doubles (increases by factor of 2)")
            ),
            mcqs = listOf(
                McqQuestion("p13_1", "At what displacement from the mean position is the kinetic energy equal to potential energy in SHM?", listOf("A / 2", "A / √2", "A / 4", "A"), 1, "1/2 k (A² - x²) = 1/2 k x²  ⇒  A² - x² = x²  ⇒  2x² = A²  ⇒  x = A / √2.", "Oscillations", SubjectType.PHYSICS)
            ),
            quickRevision = listOf(
                "At mean position (x = 0): velocity is maximum, acceleration is zero, PE is zero.",
                "At extreme position (x = ±A): velocity is zero, acceleration is maximum, PE is maximum."
            )
        ),
        Chapter(
            id = "phy_ch14",
            number = 14,
            subject = SubjectType.PHYSICS,
            title = "Waves",
            overview = "Wave motion, longitudinal and transverse waves, displacement relation for progressive wave, speed of sound (Newton's formula and Laplace's correction), standing waves, beats, and Doppler effect.",
            keyPoints = listOf(
                "Wave equation: y(x, t) = A sin(kx - ωt + φ), where wave number k = 2π/λ, ω = 2πf, speed v = ω/k = f·λ.",
                "Transverse waves oscillate perpendicular to propagation; Longitudinal waves oscillate parallel.",
                "Speed of longitudinal wave in ideal gas: v = √(γ P / ρ) (Laplace's corrected formula).",
                "Beat frequency f_beat = |f₁ - f₂|."
            ),
            formulas = listOf(
                FormulaItem("Wave Speed", "v = f · λ = ω / k", "Fundamental wave relationship", "m/s", "[L T⁻¹]"),
                FormulaItem("Speed in Gas (Laplace)", "v = √(γ R T / M)", "Adiabatic sound propagation", "m/s", "[L T⁻¹]"),
                FormulaItem("Stretched String Speed", "v = √(T_tension / μ)", "μ is linear mass density (kg/m)", "m/s", "[L T⁻¹]"),
                FormulaItem("Beat Frequency", "f_beat = |f₁ - f₂|", "Periodic amplitude modulation", "Hertz (Hz)", "[T⁻¹]")
            ),
            definitions = listOf(
                "Beats" to "Periodic variation in sound intensity resulting from the superposition of two waves of slightly different frequencies.",
                "Standing Wave" to "Wave formed by superposition of two identical waves traveling in opposite directions, having fixed nodes and antinodes."
            ),
            examples = listOf(
                SolvedExample(
                    question = "Two tuning forks of frequencies 256 Hz and 260 Hz are sounded together. How many beats are heard per second?",
                    solution = "f_beat = |f₁ - f₂| = |256 - 260| = 4 beats per second.",
                    keyStep = "Compute the absolute frequency difference."
                )
            ),
            practiceQuestions = listOf(
                PracticeQuestion("Why did Newton's formula for speed of sound in air give an erroneous value (280 m/s instead of 332 m/s)?", "Newton assumed isothermal compression, while rapid pressure cycles are adiabatic (Laplace correction)", "Laplace multiplied by √γ")
            ),
            mcqs = listOf(
                McqQuestion("p14_1", "The distance between a node and its adjacent antinode in a stationary wave is:", listOf("λ", "λ / 2", "λ / 4", "2λ"), 2, "Adjacent nodes are spaced λ/2 apart; a node and adjacent antinode are separated by λ/4.", "Waves", SubjectType.PHYSICS)
            ),
            quickRevision = listOf(
                "Nodes have zero amplitude; antinodes have maximum amplitude.",
                "Sound travels faster in denser solids and humid warm air."
            )
        )
    )
}
