# Android Paging Library Sample
Sample app demonstrating paging library.

### Solved Issues
* `loadAfter()` from `ImageDataSource` not called

In method `onBindViewHolder()` in adapter class which extends `PagedListAdapter<>`,
use `getItem(position)` instead of `currentList.get(position)`. (`loadAfter()` is invoked in `getItem()`)