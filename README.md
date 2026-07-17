# Jugo — a 3D dungeon crawler with a hand-built engine

**Jugo** is a learning project: starting from zero programming experience, we build a
retro first-person dungeon crawler in Java — and we write the 3D engine ourselves,
computing every pixel on screen with our own code. No game engine, no graphics
libraries. Just Java and math.

This is the same approach the original *Doom* (1993) used: a **software renderer**.
It is slower than a modern GPU pipeline, but it means nothing on screen is magic —
every triangle, shadow, and texture exists because *you* wrote the code that put it there.

## The goal

A playable, shippable game:

> **Walk through a multi-room 3D dungeon in first person. Enemies roam the halls.
> You fight them, collect keys, open doors, and escape. Retro PS1/Doom aesthetic.**

And a second, deeper goal: by the end, you genuinely understand how 3D graphics work —
not "I called a library function," but "I know why that pixel is that color."

## Where things live

| Document | What it's for |
|---|---|
| [docs/ROADMAP.md](docs/ROADMAP.md) | The phases: what we build, in what order, with milestones |
| [docs/DECISIONS.md](docs/DECISIONS.md) | Every significant decision, why we made it, and what we rejected |
| [docs/RESOURCES.md](docs/RESOURCES.md) | Curated learning material for each phase |

## How we work together

You are learning to program; the code is yours to write. The working agreement:

1. **Concept first.** Before each new topic, Claude explains the idea in plain language
   (with diagrams/sketches where it helps) until it makes sense.
2. **You type the code.** Claude guides, reviews, and unblocks — but doesn't write your
   game for you. Typing it yourself is where the learning happens.
3. **Grilling goes both ways.** You asked to be grilled on decisions; expect the same on
   understanding. After each milestone Claude asks you to explain, in your own words,
   how the thing you built works. If you can't, we revisit before moving on.
4. **Every phase ends with something that runs.** No phase is "done" until you can see
   it working on screen.
5. **Commit early, commit often.** Git is part of Phase 0. Small commits with messages
   that say *why*.

## Tech stack (see DECISIONS.md for the reasoning)

- **Java 21** (already installed) — modern LTS Java.
- **Gradle** (via wrapper) — build tool; added in Phase 0.
- **Plain JDK only** through Phase 6: window and pixel buffer via `java.awt`
  (`JFrame` + `BufferStrategy`), sound via `javax.sound`. Zero external dependencies.
- **Phase 7 (optional):** LWJGL 3.4.x + OpenGL, if we decide to port the renderer
  to the GPU after the game ships.

## Status

- **Current phase:** Phase 0 — Java fundamentals (in progress, step 0.1)
- **Started:** July 2026
