# **Паттерны проектирования**
### *Проверенные решения распространённых проблем в разработке программного обеспечения*
### Паттерны проектирования делятся на три основные категории: 
- порождающие (отвечают за создание объектов, например Singleton или Factory)
- структурные (организуют взаимодействие между классами, как Adapter или Decorator)
- поведенческие (определяют схемы взаимодействия объектов, такие как Observer или Visitor)
---
## Visitor
### Поведенческий паттерн Visitor (Посетитель) 
- позволяет добавлять новые операции к объектам, не изменяя их классы
- полезен при работе со сложными структурами объектов, такими как деревья или графы
---
## Преимущества паттерна Visitor:
- упрощение добавления новых операций без изменения существующих классов
- возможность объединения родственных операций
- работа со сложными структурами данных
## Недостатки паттерна Visitor:
- нарушение инкапсуляции (требует обновления всех посетителей при добавлении новых элементов)
- избыточен для простых задач
---
### В проекте реализован паттерн Visitor для трёх различных задач: 
- копирование AST выражений, где Visitor создаёт полную копию абстрактного синтаксического дерева, сохраняя его структуру и обрабатывая все типы узлов
- оптимизация AST путём сворачивания констант: Visitor анализирует дерево, вычисляет константные выражения и заменяет их результатами
- расчёт пищевой ценности блюд, где Visitor вычисляет суммарные показатели калорий, белков,  жиров, углеводом и стоимость для всех ингредиентов
