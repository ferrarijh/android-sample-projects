# RecyclerView Animation Test
Test recycler view's animation on dataset change.

1) set `setHasStableIds(true)` for adapter
2) override adapter method

example:
```kotlin
  override fun getItemId(position: Int): Long{
    return items[position].id
  }
```
