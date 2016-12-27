package com.hunterdavis.adventureneverstops.views.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

import com.hunterdavis.adventureneverstops.R;

import java.util.ArrayList;

public class DungeonMapView extends MapView {
    private final static int MAP_SIZE = 64;

    private ArrayList<Room> rooms = new ArrayList<>();
    double generatedMap[][] = null;


    public DungeonMapView(Context context) {
        super(context);
    }

    public DungeonMapView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DungeonMapView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void init(AttributeSet attrs, int defStyle) {
        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.MapView, defStyle, 0);

        a.recycle();
    }



    public int getRandom(int low, int high) {
        return (int)(Math.random() * (high - low)) + low;
    }

    private class Room {
        int x = 0;
        int y = 0;
        int w = 0;
        int h = 0;

        public Room() {

        }

        public Room(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Room getMid() {
            Room ret = new Room();
            ret.x = x + w/2;
            ret.y = y + h/2;
            return ret;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Room room = (Room) o;

            if (Double.compare(room.x, x) != 0) return false;
            if (Double.compare(room.y, y) != 0) return false;
            if (Double.compare(room.w, w) != 0) return false;
            return Double.compare(room.h, h) == 0;

        }

        @Override
        public int hashCode() {
            int result;
            long temp;
            temp = Double.doubleToLongBits(x);
            result = (int) (temp ^ (temp >>> 32));
            temp = Double.doubleToLongBits(y);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            temp = Double.doubleToLongBits(w);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            temp = Double.doubleToLongBits(h);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            return result;
        }
    }

    public Room findClosestRoom(Room room) {
        Room mid = room.getMid();

        Room closest = null;
        double closest_distance = 1000;
        for (int i = 0; i < this.rooms.size(); i++) {
            Room check = this.rooms.get(i);
            if (check.equals(room)) continue;

            Room check_mid = check.getMid();

            double distance = Math.min(Math.abs(mid.x - check_mid.x) - (room.w / 2) - (check.w / 2), Math.abs(mid.y - check_mid.y) - (room.h / 2) - (check.h / 2));
            if (distance < closest_distance) {
                closest_distance = distance;
                closest = check;
            }
        }
        return closest;
    }


    public boolean DoesCollide(Room room, int ignore) {
        for (int i = 0; i < this.rooms.size(); i++) {
            if (i == ignore) continue;
            Room check = this.rooms.get(i);
            if (!((room.x + room.w < check.x) || (room.x > check.x + check.w) || (room.y + room.h < check.y) || (room.y > check.y + check.h))) return true;
        }

        return false;
    }

    public void squashRooms() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < this.rooms.size(); j++) {
                Room room = this.rooms.get(j);
                while (true) {
                    Room oldPosition = new Room();
                    oldPosition.x = room.x;
                    oldPosition.y = room.y;

                    if (room.x > 1) room.x--;
                    if (room.y > 1) room.y--;
                    if ((room.x == 1) && (room.y == 1)) break;
                    if (this.DoesCollide(room, j)) {
                        room.x = oldPosition.x;
                        room.y = oldPosition.y;
                        break;
                    }
                }
            }
        }
    }

    private double[][] generateDungeonMap() {
        double map[][] = new double[MAP_SIZE][MAP_SIZE];
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                map[i][j] = 0;
            }
        }

        double roomCount = getRandom(10,20);
        int min_size = 5;
        int max_size = 15;

        for (int i = 0; i < roomCount; i++) {
            Room room = new Room();

            room.x = getRandom(1, MAP_SIZE - max_size - 1);
            room.y = getRandom(1, MAP_SIZE - max_size - 1);
            room.w = getRandom(min_size, max_size);
            room.h = getRandom(min_size, max_size);

            if (DoesCollide(room, -1)) {
                i--;
                continue;
            }
            room.w--;
            room.h--;

            this.rooms.add(room);
        }

        squashRooms();

        for (int i = 0; i < roomCount; i++) {
            Room roomA = rooms.get(i);
            Room roomB = findClosestRoom(roomA);

            Room pointA = new Room(getRandom(roomA.x, roomA.x + roomA.w), getRandom(roomA.y, roomA.y + roomA.h));
            Room pointB = new Room(getRandom(roomB.x, roomB.x + roomB.w),getRandom(roomB.y, roomB.y + roomB.h));


            while ((pointB.x != pointA.x) || (pointB.y != pointA.y)) {
                if (pointB.x != pointA.x) {
                    if (pointB.x > pointA.x) pointB.x--;
                    else pointB.x++;
                } else if (pointB.y != pointA.y) {
                    if (pointB.y > pointA.y) pointB.y--;
                    else pointB.y++;
                }

                map[pointB.x][pointB.y] = 1;
            }
        }

        for (int i = 0; i < roomCount; i++) {
            Room room = rooms.get(i);
            for (int x = room.x; x < room.x + room.w; x++) {
                for (int y = room.y; y < room.y + room.h; y++) {
                    map[x][y] = 1;
                }
            }
        }

        for (int x = 0; x < MAP_SIZE; x++) {
            for (int y = 0; y < MAP_SIZE; y++) {
                if (map[x][y] == 1) {
                    for (int xx = x - 1; xx <= x + 1; xx++) {
                        for (int yy = y - 1; yy <= y + 1; yy++) {
                            if (map[xx][yy] == 0) map[xx][yy] = 2;
                        }
                    }
                }
            }
        }

        return map;
    }

    @Override
    public void onMeasure(int widthSpec, int heightSpec) {
        super.onMeasure(widthSpec, heightSpec);

        // match the width to the height - perfect square
        int size = getMeasuredWidth();
        setMeasuredDimension(size, size);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // TODO: consider storing these as member variables to reduce
        // allocations per draw cycle.
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();

        int contentWidth = getWidth() - paddingLeft - paddingRight;
        int contentHeight = getHeight() - paddingTop - paddingBottom;

        double scale = contentWidth /  MAP_SIZE;

        this.rooms = new ArrayList<>();
        generatedMap = generateDungeonMap();

        // create the Paint and set its color
        Paint paint = new Paint();


        for (int y = 0; y < MAP_SIZE; y++) {
            for (int x = 0; x < MAP_SIZE; x++) {
                double tile = generatedMap[x][y];
                if (tile == 0) {
                    paint.setColor(getContext().getResources().getColor(R.color.dungeon_map_color_1));
                }
                else if (tile == 1) {
                    paint.setColor(getContext().getResources().getColor(R.color.dungeon_map_color_2));
                }
                else  {
                    paint.setColor(getContext().getResources().getColor(R.color.dungeon_map_color_3));
                }

                float left = (float) (x * scale);
                float top = (float) (y * scale);
                float right = (float)(left + scale);
                float bottom = (float)(top + scale);

                canvas.drawRect(left,top, right, bottom, paint);
            }
        }
    }

}
